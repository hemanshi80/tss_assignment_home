package com.tss.model.Inheritance.model;

import java.util.Scanner;

public class PayPal implements IBill{
	
	private String email;
	private String password;

	@Override
	public void collectDetails() {
		Scanner scanner = new Scanner(System.in);
		
		 System.out.print("Enter PayPal account holder name : ");
		 String name = scanner.nextLine();
		 System.out.print("Enter Amount :");
		 double amount = scanner.nextInt();
		 
		System.out.print("Enter PayPal Email Id :");
		email = scanner.nextLine();
		 while (!isValidEmail(email)) {
	            System.out.print("Invalid Email! Enter a valid PayPal Email: ");
	            email = scanner.nextLine();
	        }
		
		System.out.print("Enter your password (8-20):");
		password = scanner.nextLine();
		 while (password.length() < 8 || password.length() > 20) {
	            System.out.print("Invalid Password! Must be 8-20 characters: ");
	            password = scanner.nextLine();
	        }
		payment(amount);
		 scanner.close();
	}

	private boolean isValidEmail(String email) {
	
		return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
	}

	@Override
	public void payment(double amount) {
		System.out.println("Payment of " +amount + " is done through PayPal by id "+ email);
		
	}

	
}
