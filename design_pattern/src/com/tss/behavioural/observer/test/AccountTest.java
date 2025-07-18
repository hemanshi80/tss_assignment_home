package com.tss.behavioural.observer.test;

import java.util.Scanner;

import com.tss.behavioural.observer.exception.InsufficientFundsException;
import com.tss.behavioural.observer.model.Account;
import com.tss.behavioural.observer.model.EmailNotifier;
import com.tss.behavioural.observer.model.INotifier;
import com.tss.behavioural.observer.model.SMSNotifier;
import com.tss.behavioural.observer.model.WhatsappNotifier;

public class AccountTest {
	
	static Scanner scanner  = new Scanner(System.in);
    static Account account = null;

    public static void main(String[] args) {
    	
    	while(true) {
    		System.out.println("\n===== MENU =====");
            System.out.println("1. Add Account");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Add Notifier");
            System.out.println("5. Remove Notifier");
            System.out.println("6. Show Account Details");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
            case 1 :{
            	addAccount();
            	break;
            }
            case 2:{ 
            	deposit();
            	break;
            	}
            case 3 : {
            	withdraw();
            	break;
            }
            case 4 :{
            	addNotifier();
            	break;
            }
            case 5 :{
            	removeNotifier();
            	break;
            }
            case 6 :{
            	showDetails();
            	break;
            }
            case 7:{
            	System.out.println("Exiting...");
            	break;
            }
            default :{
            	System.out.println("Invalid choice!");
            }
        }         
}
    	
}
   
    static void addAccount() {
    	scanner.nextLine();
        System.out.print("Enter Account ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double bal = scanner.nextDouble();

        account = new Account(id, accNo, name, bal);
        System.out.println("Select Notifiers (y/n):");

        System.out.print("SMS Notifier? ");
        if (scanner.next().equalsIgnoreCase("y")) {
            account.registerNotifier(new SMSNotifier());
        }

        System.out.print("Email Notifier? ");
        if (scanner.next().equalsIgnoreCase("y")) {
            account.registerNotifier(new EmailNotifier());
        }

        System.out.print("WhatsApp Notifier? ");
        if (scanner.next().equalsIgnoreCase("y")) {
            account.registerNotifier(new WhatsappNotifier());
        }

        System.out.println("Account created successfully.");
    }
    
    
    static void deposit() {
    	if (account == null) {
            System.out.println("Please create an account first.");
           
        }
        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);
        
    }
    
    static void withdraw() {
    	 if (account == null) {
             System.out.println("Please create an account first.");
             
         }
         System.out.print("Enter withdraw amount: ");
         double withdrawAmount = scanner.nextDouble();
         try {
             account.withdraw(withdrawAmount);
         } catch (InsufficientFundsException e) {
             System.out.println("Error: " + e.getMessage());
         }
    }

    static void addNotifier() {
    	if (account == null) {
            System.out.println("Please create an account first.");
            
        }
        System.out.println("Add Notifier (1. SMS, 2. Email, 3. WhatsApp): ");
        int addChoice = scanner.nextInt();
        switch (addChoice) {
            case 1:
                account.registerNotifier(new SMSNotifier());
                break;
            case 2:
                account.registerNotifier(new EmailNotifier());
                break;
            case 3:
                account.registerNotifier(new WhatsappNotifier());
                break;
            default:
                System.out.println("Invalid notifier choice.");
        }
    }
    
   static void removeNotifier() {
	   
	   if (account == null) {
           System.out.println("Please create an account first.");
       }
       System.out.println("Remove Notifier (1. SMS, 2. Email, 3. WhatsApp): ");
       int removeChoice = scanner.nextInt();
       switch (removeChoice) {
           case 1:
               account.removeNotifier(new SMSNotifier());
               break;
           case 2:
               account.removeNotifier(new EmailNotifier());
               break;
           case 3:
               account.removeNotifier(new WhatsappNotifier());
               break;
           default:
               System.out.println("Invalid notifier choice.");
       }
       
   }
    
    
    static void showDetails() {
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("No account found.");
        }
    }
    

}
