package com.arun.printevenandodd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitAndSignalAll {

	public static void main(String[] args) {

		ReentrantLock lock = new ReentrantLock();
		Condition c1 = lock.newCondition();
		Condition c2 = lock.newCondition();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					lock.lock();
					for (int i = 1; i <= 10; i++) {

						if (i % 2 != 0) {
							System.out.println(i);
							c2.signalAll();
						} else {
							c1.await();
						}

					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					lock.lock();
					for (int i = 2; i <= 10; i++) {

						if (i % 2 == 0) {
							System.out.println(i);
							c1.signalAll();
						} else {
							c2.await();
						}

					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}

			}
		});
		t1.start();
		t2.start();
	}

}
