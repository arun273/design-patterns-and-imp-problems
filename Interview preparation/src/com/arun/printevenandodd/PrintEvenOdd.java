package com.arun.printevenandodd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintEvenOdd {

	Lock lock;
	Condition evenCondition;
	Condition oddCondition;

	public static void main(String[] args) {
		PrintEvenOdd printEvenOdd = new PrintEvenOdd();
		printEvenOdd.lock = new ReentrantLock();
		printEvenOdd.evenCondition = printEvenOdd.lock.newCondition();
		printEvenOdd.oddCondition = printEvenOdd.lock.newCondition();

		Thread evenThread = new Thread(() -> {
			printEvenOdd.printEven();
		});
		Thread oddThread = new Thread(() -> {
			printEvenOdd.printOdd();
		});
		evenThread.start();
		oddThread.start();
	}

	private void printEven() {
		try {
			lock.lockInterruptibly();
		} catch (InterruptedException e) {

		}

		int i = 0;
		while (i < Integer.MAX_VALUE) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
				if (i % 10 == 0)
					System.out.println();
				oddCondition.signal();
				try {
					evenCondition.await();
				} catch (InterruptedException e) {

				}
			}
			i += 1;
		}
		lock.unlock();
	}

	private void printOdd() {
		try {
			lock.lockInterruptibly();
		} catch (InterruptedException e) {

		}

		int i = 0;
		while (i < Integer.MAX_VALUE) {
			if (i % 2 == 1) {
				System.out.print(i + " ");
				evenCondition.signal();
				try {
					oddCondition.await();
				} catch (InterruptedException e) {

				}
			}
			i += 1;
		}
		lock.unlock();
	}	
}
