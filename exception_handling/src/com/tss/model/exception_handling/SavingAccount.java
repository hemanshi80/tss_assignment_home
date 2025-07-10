package com.tss.model.exception_handling;

import com.tss.exception.MinimumBalanceViolationException;
import com.tss.exception.OverDraftReachedLimitException;

public class SavingAccount extends Account{

	private double minimumBalance;

	public SavingAccount(String name, int accNum, double balance, double minimumBalance) {
		super(name, accNum, balance);
		this.minimumBalance = minimumBalance;
	}
	
	public void credit (double amnt) {
		balance = balance + amnt;
		System.out.println("Credited Successfully , New Balance :" + balance);
	}
	
	public void OverDraft(double amount) {
		if (balance - amount >= -minimumBalance) {
            balance -= amount;
            System.out.println("Amount debited successfully. New balance: " + balance);
        } else {
            throw new MinimumBalanceViolationException (balance);

        }		
	}
	
	public void displayCurrentAccount() {
		super.display();
		System.out.println("Required minimum Balance :" + minimumBalance);
	}

	
}
