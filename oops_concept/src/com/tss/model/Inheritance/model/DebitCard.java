package com.tss.model.Inheritance.model;

import java.util.Scanner;

public class DebitCard implements IBill{
	private String cardNumber;
    private String cvv;
    
	@Override
	public void collectDetails() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Account Holder name : ");
		String name = scanner.nextLine();
		System.out.print("Enter Amount :");
		double amount = scanner.nextInt();
        System.out.print("Enter Debit Card Number (16 digits): ");
        cardNumber = scanner.nextLine();
        while (!cardNumber.matches("\\d{16}")) {
            System.out.print("Invalid! Enter 16-digit Card Number: ");
            cardNumber = scanner.nextLine();
        }
        
        System.out.print("Enter CVV (3 digits): ");
        cvv = scanner.nextLine();
        while (!cvv.matches("\\d{3}")) {
            System.out.print("Invalid! Enter 3-digit CVV: ");
            cvv = scanner.nextLine();
        }
       payment(amount);

        scanner.close();
		
	}
	
	@Override
	public void payment(double amount) {
		System.out.println("Payment of " + amount + " is done through Debit Card with card number "+cardNumber);
		
	}

	
}
