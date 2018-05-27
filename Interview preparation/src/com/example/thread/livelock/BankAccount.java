package com.example.thread.livelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
	double balance;
	int id;
	Lock lock = new ReentrantLock();

	BankAccount(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	boolean withdraw(double amount) {
		if (this.lock.tryLock()) {
			// Wait to simulate io like database access ...
			try {
				Thread.sleep(10l);
			} catch (InterruptedException e) {
			}
			balance -= amount;
			return true;
		}
		return false;
	}

	boolean deposit(double amount) {
		if (this.lock.tryLock()) {
			// Wait to simulate io like database access ...
			try {
				Thread.sleep(10l);
			} catch (InterruptedException e) {
			}
			balance += amount;
			return true;
		}
		return false;
	}

	public boolean tryTransfer(BankAccount destinationAccount, double amount) {
		if (this.withdraw(amount)) {
			if (destinationAccount.deposit(amount)) {
				return true;
			} else {
				// destination account busy, refund source account.
				this.deposit(amount);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		final BankAccount fooAccount = new BankAccount(1, 500d);
		final BankAccount barAccount = new BankAccount(2, 500d);

		new Thread(new Transaction(fooAccount, barAccount, 10d),
				"transaction-1").start();
		new Thread(new Transaction(barAccount, fooAccount, 10d),
				"transaction-2").start();

	}

}

class Transaction implements Runnable {
	private BankAccount sourceAccount, destinationAccount;
	private double amount;

	Transaction(BankAccount sourceAccount, BankAccount destinationAccount,
			double amount) {
		this.sourceAccount = sourceAccount;
		this.destinationAccount = destinationAccount;
		this.amount = amount;
	}

	public void run() {
		while (!sourceAccount.tryTransfer(destinationAccount, amount))
			continue;
		System.out.printf("%s completed ", Thread.currentThread().getName());
	}

}

/*
LiveLock

A LiveLock looks like a deadlock in the sense that two (or more) processes are blocking each others. But with the livelock, each process is waiting “actively”, trying to resolve the problem on its own (like reverting back its work and retry). A live lock occurs when the combination of these processes’s efforts to resolve the problem makes it impossible for them to ever terminate.
Let’s take the example of the bank account again. Suppose another erroneous implementation of two simultaneous transfer operation. Here again, two threads tries to transfer money from one account to another one at the same time. But this time, instead of waiting for a lock to be released when a required account is locked, a thread will juste revert its work if any, and retry the whole operation in loop until successful : 

The result of this execution is somewhat similar to the one of the deadlock example, but this time the CPU is working harder.
Typically the program will execute like this :

    transaction-1 withdraw 10$ from account “1”
    transaction-2 withdraw 10$ from account “2”
    transaction-1 failed to deposit in account “2” because “transaction-2” already old the lock on that account. Account “1” refunded
    transaction-2 failed to deposit in account “1” because “transaction-1” already old the lock on that account. Account “2” refunded
    transaction-1 withdraw 10.000000 from account “1”
    transaction-2 withdraw 10.000000 from account “2”
    transaction-1 failed to deposit in account “2” because “transaction-2” already old the lock on that account. Account “1” refunded
    transaction-2 failed to deposit in account “1” because “transaction-1” already old the lock on that account. Account “2” refunded
    and so on …
*/