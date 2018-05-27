package com.arun.printevenandodd;

public class Print1to100Using2threadsWithoutWaitAndNotify {
	

	public static void main(String[] args) {
		new Thread(new OddPrint()).start();
		new Thread(new EvenPrint()).start();
	}

}



class OddPrint implements Runnable {
	static boolean flag = true;
	public void run() {
		for (int i = 1; i <= 99;) {
			if (flag) {
				System.out.print(i + " ");
				flag = false;
				i = i + 2;
			}
		}
	}
}

class EvenPrint implements Runnable {

	public void run() {

		for (int i = 2; i <= 100;) {
			if (!OddPrint.flag) {
				System.out.print(i + " ");
				OddPrint.flag = true;
				i = i + 2;
			}
		}
	}
}
