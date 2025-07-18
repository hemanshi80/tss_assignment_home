package com.tss.behavioural.observer.model;

import java.util.ArrayList;
import java.util.List;

import com.tss.behavioural.observer.exception.InsufficientFundsException;

public class Account {

	   private int accountId;
	    private String accountNumber;
	    private String name;
	    private double balance;
	    private List<INotifier> notifiers = new ArrayList<>();
	    
	    public Account(int accountId, String accountNumber, String name, double balance) {
	        this.accountId = accountId;
	        this.accountNumber = accountNumber;
	        this.name = name;
	        this.balance = balance;
	    }

	    public int getAccountId() {
			return accountId;
		}


		public String getAccountNumber() {
			return accountNumber;
		}

		public String getName() {
			return name;
		}

		public double getBalance() {
			return balance;
		}

		public List<INotifier> getNotifiers() {
			return notifiers;
		}


	    public void registerNotifier(INotifier notifier) {
	        for (INotifier existing : notifiers) {
	            if (existing.getClass() == notifier.getClass()) {
	                System.out.println("Notifier already registered: " + notifier.getClass().getSimpleName());
	                return;
	            }
	        }
	        notifiers.add(notifier);
	    }
	    public void removeNotifier(INotifier notifier) {
	        for (INotifier existing : notifiers) {
	            if (existing.getClass() == notifier.getClass()) {
	                notifiers.remove(existing);
	                System.out.println("Removed notifier: " + notifier.getClass().getSimpleName());
	                return;
	            }
	        }
	        System.out.println("Notifier not found: " + notifier.getClass().getSimpleName());
	    }

	    public void deposit(double amount) {
	        balance += amount;
	        for (INotifier notifier : notifiers) {
	            notifier.sendNotification("Deposited: ", amount);
	        }
	    }

	    public void withdraw(double amount) throws InsufficientFundsException {
	        if (amount > balance) {
	            throw new InsufficientFundsException("Insufficient funds! Cannot withdraw: " + amount);
	        }
	        balance -= amount;
	        for (INotifier notifier : notifiers) {
	            notifier.sendNotification("Withdrawn: ", amount);
	        }
	    }

	    @Override
	    public String toString() {
	        return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	    }

		
}
