package com.tss.model.Inheritance.test;

import java.util.Scanner;
import com.tss.model.Inheritance.model.Account;
import com.tss.model.Inheritance.model.CurrentAccount;
import com.tss.model.Inheritance.model.SavingAccount;

public class AccountTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Account account = null;
		
		while(true) {
			System.out.println("1. Create Current Account");
			System.out.println("2. Create Saving Account");
			System.out.println("3. Credit Amount");
			System.out.println("4. Debit Amount");
			System.out.println("5. Display Account Details");
			System.out.println("6. Exit");
			System.out.println("Enter your choice :");
			int option = sc.nextInt();
			
			switch(option)
			{
			case 1:
			{
				 System.out.print("Enter Acc No: ");
                 int cAccNo = sc.nextInt();
                 sc.nextLine();
                 System.out.print("Enter Name: ");
                 String cName = sc.nextLine();
                 System.out.print("Enter Balance: ");
                 double cBalance = sc.nextDouble();
                 System.out.print("Enter Overdraft Limit: ");
                 double limit = sc.nextDouble();
                 account = new CurrentAccount( cName,cAccNo, cBalance, limit);
                 System.out.println("Current account created.");
                 break;
			}
			
			case 2:
			{
                System.out.print("Enter Acc No: ");
                int sAccNo = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String sName = sc.nextLine();
                System.out.print("Enter Balance: ");
                double sBalance = sc.nextDouble();
                System.out.print("Enter Minimum Balance: ");
                double minBal = sc.nextDouble();
                account = new SavingAccount( sName, sAccNo,sBalance, minBal);
                System.out.println("Savings account created.");
                break;
		}
			
			 case 3:
                 if (account != null) {
                     System.out.print("Enter amount to credit: ");
                     double amt = sc.nextDouble();
                     account.credit(amt);
                 } else {
                     System.out.println("Create an account first.");
                 }
                 break;
                 
               
			 case 4:
                 if (account != null) {
                     System.out.print("Enter amount to debit: ");
                     double amt = sc.nextDouble();
                     if (account instanceof CurrentAccount) {
                         ((CurrentAccount) account).OverDraft(amt);
                     } else if (account instanceof SavingAccount) {
                         ((SavingAccount) account).OverDraft(amt);
                     }
                 } else {
                     System.out.println("Create an account first.");
                 }
                 break;
			

             case 5:
                 if (account != null) {
                     account.display();
                 } else {
                     System.out.println("No account to display.");
                 }
                 break;

             case 6:
                 System.out.println("Thank you for using the bank app.");
                 sc.close();
                 System.exit(0);

             default:
                 System.out.println("Invalid choice!");
	}

}
	}
}