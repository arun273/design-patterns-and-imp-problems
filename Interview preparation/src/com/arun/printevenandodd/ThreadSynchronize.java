package com.arun.printevenandodd;

public class ThreadSynchronize {

	public static void main(String[] args) throws InterruptedException {

		Object lock = new Object();
		Runnable evenThread = new Counter(0, lock);
		Runnable oddThread = new Counter(1, lock);
		Thread evenWorker = new Thread(evenThread);
		Thread oddWorker = new Thread(oddThread);
		evenWorker.start();
		oddWorker.start();

	}

}

class Counter implements Runnable {

	private int start;
	private Object lock;

	public Counter(int seed, Object lock) {
		start = seed;
		this.lock = lock;

	}

	@Override
	public void run() {

 {
			start += 2;
			System.out.println(start);
			synchronized (lock) {
				try {
					lock.notify();
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}
}
