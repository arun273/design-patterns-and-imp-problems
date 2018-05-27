package com.arun.printevenandodd;

public class Print1to100Using2threadsWithSynchronized {

	private static Object lock = new Object();

	public static void main(String[] args) {
		new Thread(new OddPrintSynchronized(lock)).start();
		new Thread(new EvenPrintSynchronized(lock)).start();
	}
}

class OddPrintSynchronized implements Runnable {

	static boolean flag = true;
	private Object lock = null;

	public OddPrintSynchronized(Object lock) {
		this.lock = lock;
	}

	public void run() {

		for (int i = 1; i <= 99; i = i + 2) {
			synchronized (lock) {
				while (!flag) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						System.out.println("Error in Thread 1: " + e.getMessage());
					}
				}
				System.out.println("Thread 1: " + i);
				flag = false;
				lock.notifyAll();
			}

		}
	}
}

class EvenPrintSynchronized implements Runnable {

	private Object lock = null;

	public EvenPrintSynchronized(Object lock) {
		this.lock = lock;
	}

	public void run() {

		for (int i = 2; i <= 100; i = i + 2) {
			synchronized (lock) {
				while (OddPrintSynchronized.flag) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						System.out.println("Error in Thread 2: " + e.getMessage());
					}
				}
				System.out.println("Thread 2: " + i);
				OddPrintSynchronized.flag = true;
				lock.notifyAll();
			}

		}
	}

}
