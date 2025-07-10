package com.tss.model.Inheritance.model;

public class CurrentAccount extends Account {

	private double overDraftLimit;

	public CurrentAccount(String name, int accNum, double balance, double overDraftLimit) {
		super(name, accNum, balance);
		this.overDraftLimit = overDraftLimit;
	}
	
	public void credit (double amnt) {
		balance = balance + amnt;
		System.out.println("Credited Successfully :" + balance);
	}
	
	
	public void OverDraft(double amount) {
		if (balance - amount >= -overDraftLimit) {
            balance -= amount;
            System.out.println("Amount debited successfully. New balance: " + balance);
        } else {
            System.out.println("Debit failed: Exceeds overdraft limit.");
        }		
	}
	
	public void displayCurrentAccount() {
		super.display();
		System.out.println("Over Draft  :" + overDraftLimit);
	}

	

	
}
