package com.tss.payment;

public class Cash implements IPayment {

	 private static final long serialVersionUID = 1L;

	    private double cashAmount;

	    public Cash(double cashAmount) {
	        this.cashAmount = cashAmount;
	    }

	    @Override
	    public boolean pay(double amount) {
	        System.out.println("Cash payment of " + amount + " will be collected on delivery.");
	        return true;
	    }

	    @Override
	    public String getPaymentMode() {
	        return "Cash";
	    }

	    public double getCashAmount() {
	        return cashAmount;
	    }
}