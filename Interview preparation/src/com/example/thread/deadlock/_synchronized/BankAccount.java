package com.example.thread.deadlock._synchronized;

public class BankAccount {
	double balance;
	int id;

	BankAccount(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	void withdraw(double amount) {
		// Wait to simulate io like database access ...
		try {
			Thread.sleep(10l);
		} catch (InterruptedException e) {
		}
		balance -= amount;
		System.out.println(balance);
	}

	void deposit(double amount) {
		// Wait to simulate io like database access ...
		try {
			Thread.sleep(10l);
		} catch (InterruptedException e) {
		}
		balance += amount;
		System.out.println(balance);
	}

	static void transfer(BankAccount from, BankAccount to, double amount) {
		synchronized (from) {
			from.withdraw(amount);
			synchronized (to) {
				to.deposit(amount);
			}
		}
	}

	public static void main(String[] args) {
		final BankAccount fooAccount = new BankAccount(1, 100d);
		final BankAccount barAccount = new BankAccount(2, 100d);

		new Thread() {
			public void run() {
				BankAccount.transfer(fooAccount, barAccount, 10d);
			}
		}.start();

		new Thread() {
			public void run() {
				BankAccount.transfer(barAccount, fooAccount, 10d);
			}
		}.start();

	}
}

/*Deadlock

I think the deadlock is the easiest one to understand. It happens when a process wait for another one who is using some needed resource (ie: file or database table row) to finish with it, while the other process also wait for the first process to release some other resource.

In the following example, two different threads attempts to transfer money between the two same accounts at the same time : 

Here is what happens. Thread1 wants to transfer 10 dollars from foo account to bar account. Almost at the same time, Thread2 wants to tranfer 10 dollars from the bar account to the foo account. Here how goes the execution of the code above :

    Thread1 starts
    Thread2 starts
    Thread1 try to lock account foo. Nobody is locking foo so the lock is granted to thread 1.
    Thread2 try to lock account bar. Nobody is locking bar so the lock is granted to thread 2.
    Thread1 try to lock account bar. Since Thread2 is already olding the lock on the bar account, Thread1 is NOT granted the lock.
    Thread2 try to lock account foo. Since Thread1 is already olding the lock on the foo account, Thread2 is NOT granted the lock.
    Thread1 waits for Thread2 to release the lock on the bar account.
    Thread2 waits for Thread1 to release the lock on the foo account.
*/