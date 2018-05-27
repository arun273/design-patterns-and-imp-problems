package com.arun.printsequencingnumbers123123;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadSequence {

	private static final Lock lock = new ReentrantLock();
	private static final Condition isAvailable = lock.newCondition();
	private static List<Integer> validNos = Arrays.asList(1, 2, 3);
	private static int roundRobbin = 1;

	private static int getNextNumber(int number) {
		if (number < 3) {
			return number + 1;
		} else {
			return 1;
		}
	}

	
	private static boolean isValid(final Integer number) {
		return validNos.contains(number);
	}

	public static Runnable getRunnable(final Integer number) {
		if (!isValid(number)) {
			throw new IllegalArgumentException("Please provide a valid input: " + number);
		}
		return new Runnable() {

			public void run() {
				while (true) {
					try {
						lock.lock();
						while (roundRobbin != number) {
							isAvailable.await();
						}
						System.out.println(number);
						roundRobbin = getNextNumber(number);
						isAvailable.signalAll();
					} catch (Exception e) {
						System.err.println("Error acquiring lock for : " + number);
					} finally {
						lock.unlock();
					}
				}
			}
		};
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(getRunnable(1));
		Thread t2 = new Thread(getRunnable(2));
		Thread t3 = new Thread(getRunnable(3));

		t1.start();
		t2.start();
		t3.start();
	}
}
