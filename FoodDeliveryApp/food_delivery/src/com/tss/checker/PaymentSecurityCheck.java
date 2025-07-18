package com.tss.checker;

public class PaymentSecurityCheck {

	  public static boolean isValidCardNumber(String cardNumber) {
	        return cardNumber != null && cardNumber.matches("\\d{16}");
	    }

	    public static boolean isValidExpiryDate(String expiryDate) {
	        return expiryDate != null && expiryDate.matches("(0[1-9]|1[0-2])/\\d{2}");
	    }

	    public static boolean isValidCardHolderName(String name) {
	        return name != null && name.trim().length() > 2;
	    }

	    public static boolean isValidCashAmount(double amount) {
	        return amount > 0;
	    }

	    public static boolean isValidUPI(String upiId) {
	        return upiId != null && upiId.matches("^[\\w.]+@[\\w]+$");
	    }
}	