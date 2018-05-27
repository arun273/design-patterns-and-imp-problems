package com.arun.printsequencingnumbers123123;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Thread123 {

	public static void main(String... args) {
		Semaphore sem1 = new Semaphore(1);
		Semaphore sem2 = new Semaphore(0);
		Semaphore sem3 = new Semaphore(0);

		ExecutorService executorService = Executors.newFixedThreadPool(10);

		executorService.execute(new WorkerThread(1, sem1, sem2));
		executorService.execute(new WorkerThread(2, sem2, sem3));
		executorService.execute(new WorkerThread(3, sem3, sem1));

	}
}

class WorkerThread implements Runnable {

	private int command;
	private Semaphore s1;
	private Semaphore s2;

	public WorkerThread(int s, Semaphore s1, Semaphore s2) {
		this.command = s;
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void run() {
		while (true) {

			try {
				s1.acquire();

				System.out.println(command);
				s2.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}