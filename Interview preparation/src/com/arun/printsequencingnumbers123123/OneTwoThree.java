package com.arun.printsequencingnumbers123123;

import java.util.concurrent.atomic.AtomicInteger;

public class OneTwoThree {

	public static AtomicInteger shared = new AtomicInteger(1);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread even = new Thread(new one(1));
		Thread odd = new Thread(new one(2));
		Thread third = new Thread(new one(3));
		even.start();
		odd.start();
		third.start();

	}

}

class one implements Runnable {
	int threadid;

	public one(int num) {
		this.threadid = num;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			if (OneTwoThree.shared.get() % 4 == this.threadid) {
				int i = OneTwoThree.shared.get();
				System.out.println("Thread ID -->>" + this.threadid + "Value-->>" + i);

				if (OneTwoThree.shared.incrementAndGet() >= 4) {
					OneTwoThree.shared.set(1);
				}

			}

		}

	}

}
