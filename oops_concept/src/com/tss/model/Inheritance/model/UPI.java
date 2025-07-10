package com.tss.model.Inheritance.model;

import java.util.Scanner;

public class UPI implements IBill {
	String upiId;
	
	@Override
    public void collectDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter UPI account holder name : ");
		String name = scanner.nextLine();
		System.out.print("Enter Amount :");
		double amount = scanner.nextInt();
        System.out.print("Enter UPI ID (end with bank name): ");
        upiId = scanner.nextLine();
        while (!!isValidId(upiId)) {
            System.out.print("Invalid! Enter valid UPI ID: ");
            upiId = scanner.nextLine();
        }
        payment(amount);

        scanner.close();
    }
	
	private boolean isValidId(String upiId) {
		
		return upiId.matches("^[a-zA-Z0-9.-]{2, 256}@[a-zA-Z][a-zA-Z]{2, 64}$");
	}

	@Override
	public void payment(double amount) {
		System.out.println("Payment of " +amount +" is done through UPI with id "+ upiId);
		
	}

	
}
