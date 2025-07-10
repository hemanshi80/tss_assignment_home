package com.tss.test;

import java.util.Random;
import java.util.Scanner;

import com.tss.model.Account;
import com.tss.model.AccountType;

public class AccountTest1 {
	
	static String[] usedAccountNumbers;
	static int accountIdCounter = 1;
	static int accCount =0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of accounts to be created");
		int n = scanner.nextInt();
		Account[] account = new Account[n];
		usedAccountNumbers = new String[n];
		int i =0;
		
			
		while(true) {
			if (i < n) {
			System.out.println("1. Create Account");
			}
			System.out.println("2. Display Balance");
			System.out.println("3. Deposit");
			System.out.println("4. Withdrwan");
			System.out.println("5. Transfer");
			System.out.println("6. Exit");
			System.out.println("Enter your choice :");
			int option = scanner.nextInt();
		
			if (i >= n) {
			if(	option == 1) {
				System.out.println("Invalid Option");
				continue;
			}	
	}
			
		switch(option) {
		   case 1:
			  
			   readDetails(account , scanner , i);
			   i++;
			  
			   break;
			   
		   case 2:{
			   {   
				   	System.out.print("Enter account id :");
				   	int id = scanner.nextInt();
				   	
				   	Account acc = findAccount(account, id);
				   	if(acc != null) {
				   		System.out.println("Current Balance :"+ acc.getBalance());
				   		
				   	}
				   	else {
				   		System.out.println("Invalid Account Id");
				   	}
					
				}
				break;
		   }
		   
		   case 3:{
			   { 
				   	System.out.println("Enter account id :");
				   	int id = scanner.nextInt();
				   	
				   	Account acc = findAccount(account, id);
				   	if(acc != null) {
				   		System.out.println("Enter Amount :");
					   	int amount = scanner.nextInt();
				   		acc.deposit(amount);
				   	}
				   	else {
				   		System.out.println("Invalid Account Id");
				   	}	
				}
				break;
		   }
		   
		   case 4:{
					System.out.println("Enter account id :");
				   	int id = scanner.nextInt();
				   	
				   	Account acc = findAccount(account, id);
				   	if(acc != null) {
				   		System.out.println("Enter Amount :");
					   	int amount = scanner.nextInt();
				   		acc.withdraw(amount);
				   	}
				   	else {
				   		System.out.println("Invalid Account Id");
				   	}
				}
		   break;
			
           case 5:
        	   System.out.println("Enter Source account id :");
			   int srcid = scanner.nextInt();
			   Account srcacc = findAccount(account, srcid);

			   System.out.println("Enter Destination account id :");
			   int desid = scanner.nextInt();
			   
			   Account desacc = findAccount(account, desid);
			   if((srcacc != null)&& (desacc !=null)) {
				   System.out.println("Enter amount to be transfered :");
				   int transferamnt = scanner.nextInt();
				   srcacc.withdraw(transferamnt);
				   desacc.deposit(transferamnt);
			   }
			   
               break;

           case 6:
               System.out.println("Exiting program. Thank you!");
               return;

           default:
               System.out.println("Invalid choice.");
		}
		
		}
		
		
	}
	
	private static Account findAccount(Account[] account, int id) {
		
		for(Account acc : account) {
			if( id == acc.getAccountId()) {
				return acc;
			}
		}
		return null;
	}

	public static void readDetails(Account account[], Scanner scanner , int i) {
		int accountId = accountIdCounter++; 
		
		String accountNumber = generateUniqueAccountNumber(account ); 
		
		System.out.println("Enter Customer name :");
		String name = scanner.next();
		
		System.out.println("Enter Initial Balance :");
		int balance = scanner.nextInt();
		
		if (balance < 500) {
			System.out.println("Insufficient Balance minimum 500 required!!!");
			return;
		}
		
		boolean acc = false;
		while(!acc) {
			System.out.println("Enter Account Type 1-SAVINGS , 2-CURRENT , 3-FD");
			int typeNumber = scanner.nextInt();
			if (typeNumber == 1) {
				account[i] = new Account(accountId,accountNumber,balance,name,AccountType.SAVINGS); 
				acc = true;
			}
			else if(typeNumber == 2) {
				account[i] = new Account(accountId,accountNumber,balance,name,AccountType.CURRENT); 
				acc = true;
			}
			else if (typeNumber == 3){
				account[i]= new Account(accountId,accountNumber,balance,name,AccountType.FD); 
				acc = true;
			}
			else {
				System.out.println("Account Type Invalid");
			}
		}
		System.out.println("Account Number : "+ account[i].getAccountNumber());
		System.out.println("Account Id : "+account[i].getAccountId());
		System.out.println("Account Created !!! \n");
		
	}
	
	public static String generateUniqueAccountNumber(Account[] account) {
	    Random rand = new Random();
	    String accNum;
	    boolean unique;

	    do {
	        accNum = "AXIS1000" + rand.nextInt(1000000);  
	        unique = false;
	       for (Account acc : account) {
	            if (acc != null && accNum.equals(acc.getAccountNumber())) {
	                unique = true; 
	                break;
	            }
	        }

	    } while (unique);

	    return accNum;
	}

	
	
	
	
	

}
