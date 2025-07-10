package com.tss.model.Inheritance.model;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CreditCard implements IBill{
	
	
	private String cardNumber;
    private String expiry;
    private String cvv;

    @Override
    public void collectDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Holder name : ");
		String name = scanner.nextLine();
		System.out.print("Enter Amount :");
		double amount = scanner.nextInt();
		scanner.nextLine();
        System.out.print("Enter Credit Card Number (16 digits): ");
        cardNumber = scanner.nextLine();
        while (!cardNumber.matches("\\d{16}")) {
            System.out.print("Invalid! Enter 16-digit Card Number: ");
            cardNumber = scanner.nextLine();
        }

        System.out.print("Enter Expiry Date (MM/YY): ");
        expiry = scanner.nextLine();
        while (!isValidExpiry(expiry)) {
            System.out.print("Invalid or Expired! Enter Expiry Date (MM/YY): ");
            expiry = scanner.nextLine();
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

    private boolean isValidExpiry(String expiry) {
		
    	try {
            // Parse to YearMonth
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            YearMonth exp = YearMonth.parse(expiry, formatter);
            YearMonth now = YearMonth.now();

            return exp.isAfter(now) || exp.equals(now); 
        } catch (DateTimeParseException e) {
            return false; // invalid format
        }
	}

	@Override
    public void payment(double amount) {
        System.out.println("Payment of ₹" + amount + " is done through Credit Card ending with " + cardNumber);
    }
	

}
