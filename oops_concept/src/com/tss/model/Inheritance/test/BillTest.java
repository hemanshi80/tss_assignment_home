package com.tss.model.Inheritance.test;

import java.util.Scanner;

import com.tss.model.Inheritance.model.CreditCard;
import com.tss.model.Inheritance.model.DebitCard;
import com.tss.model.Inheritance.model.PayPal;
import com.tss.model.Inheritance.model.UPI;

public class BillTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1. Credit Card ");
		System.out.println("2. Debit Card");
		System.out.println("3. UPI Payment"); 
		System.out.println("4. PayPal");
		System.out.print("Enter your choice :");
		int option = scanner.nextInt();
		
		switch (option) {
		
		case 1 : 
			CreditCard credit = new CreditCard();
			credit.collectDetails();
			break;
			
		case 2:
			DebitCard debit = new DebitCard();
			debit.collectDetails();
			break;
			
		case 3:
			UPI upi = new UPI();
			upi.collectDetails();
			break;
			
		case 4:
			PayPal paypal = new PayPal();
			paypal.collectDetails();
			break;
			
		default :
			
			System.out.println("Invalid Choice!!");
		}
		
		scanner.close();
	}

}
