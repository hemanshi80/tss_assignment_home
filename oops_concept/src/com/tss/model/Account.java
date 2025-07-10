package com.tss.model;

public class Account {

	private int accountId,balance;
	private String name,accountNumber;
	private AccountType accountType;
	
	public Account() {
		accountId = 0;
		accountNumber = "";
		balance =0;
		name = "";
	}
	
	public Account(int accountId,String accountNumber,int balance,String name,AccountType accountType) {
		this.accountId = accountId;
		this.accountNumber = accountNumber ;
		this.balance =balance ;
		this.name = name;
		this.accountType = accountType;
	}
		
	
		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}
		
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public void setBalance(int balance) {
			this.balance = balance;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public int getAccountId() {
			return accountId;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public int getBalance() {
			return balance;
		}

		public String getName() {
			return name;
		}

		public AccountType getAccountType() {
			return accountType;
		}

		public void setAccountType(AccountType accountType) {
			this.accountType = accountType;
		}
		
		public void deposit (int amount) {
			if (amount >0) {
				balance = balance + amount; 
				System.out.println("Deposited Successfully.");
				
			}
			else {
				System.out.println("Invalid amount");
			}
		}
		
		public void withdraw (int amount) {
			if(amount <= 0 ) {
				System.out.println("Insufficient Balance in your account");
				return;
			}
			if (balance - amount >=500) {
				balance = balance - amount;
				System.out.println("Withdrawn successfully :" + amount);
				System.out.println("Balance left :" + balance);
			}
			else {
				System.out.println("500 balanace required minimum.");
			}
			
		}
		

	}
	
	

