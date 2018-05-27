package com.arun.printsequencingnumbers123123;

public class Thread123withoutlock {
	public static void main(String[] args) {

		boolean oneCheck = true;
		MyThread thread1 = new MyThread(1, oneCheck);
		MyThread thread2 = new MyThread();
		MyThread thread3 = new MyThread();

		thread1.start();
		thread2.start();
		thread3.start();

	}
}

class MyThread extends Thread implements Runnable {
	int data = 0;
	boolean oneCheck, twoCheck = false, threeCheck = false;

	public MyThread() {

	}

	public MyThread(int data, boolean oneCheck) {
		this.data = data;
		this.oneCheck = oneCheck;
	}

	public void run() {
		while (true) {
			// synchronized (MyThread.class) {
			if (oneCheck) {
				System.out.print(data + " ");
				twoCheck = true;
				oneCheck = false;
				data = 2;
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (twoCheck) {
				System.out.print(data + " ");
				twoCheck = false;
				threeCheck = true;
				data = 3;
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (threeCheck) {
				System.out.print(data + " ");
				oneCheck = true;
				threeCheck = false;
				data = 1;
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// }
		}

	}
}
