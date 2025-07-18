package com.tss.model;

public class Discount implements IDiscount {

	 private static final long serialVersionUID = 1L;
	    private double percentage;
	    private final double minAmount = 500;

	    public Discount(double percentage) {
	        this.percentage = percentage;
	    }

	    @Override
	    public double applyDiscount(double totalAmount) {
	        if (totalAmount >= minAmount) {
	            double discountAmount = totalAmount * (percentage / 100);
	            System.out.printf("Discount of %.2f%% applied (saved ₹%.2f)%n", percentage, discountAmount);
	            return totalAmount - discountAmount;
	        } else {
	            System.out.printf("No discount applied. Order must be at least ₹%.2f%n", minAmount);
	            return totalAmount;
	        }
	    }
	    
	    
	    public double getPercentage() {
	        return percentage;
	    }

	    public void setPercentage(double percentage) {
	        this.percentage = percentage;
	    }

	    public double getMinAmount() {
	        return minAmount;
	    }
}
