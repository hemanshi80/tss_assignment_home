package com.tss.model.exception_handling;

public abstract class Account {

	private String name ="";
	private int accNum ;
	protected double balance;
	
	
	public Account(String name, int accNum, double balance) {
		super();
		this.name = name;
		this.accNum = accNum;
		this.balance = balance;
	}
	
	public abstract void credit (double amnt) ;
	public abstract void OverDraft (double amnt) ;


	
	public void display() {
		System.out.println("----------------------------------DISPLAY DETAILS--------------------------------------");
		System.out.println("Account Holder Name :" + name);
		System.out.println("Account Number:" + accNum);
		System.out.println("Account' Balance :" + balance);
		System.out.println("---------------------------------------------------------------------------------------");

	}
	
	
}
