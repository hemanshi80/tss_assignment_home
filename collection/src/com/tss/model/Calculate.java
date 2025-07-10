package com.tss.model;

public class Calculate {

	
	 public static final double TAX_PERCENT = 10.0;

	    public double calculateTax(InvoiceSolid invoice) {
	        return invoice.getCost() * TAX_PERCENT / 100;
	    }

	    public double calculateDiscount(InvoiceSolid invoice) {
	        return invoice.getCost() * invoice.getDiscountPercent() / 100;
	    }

	    public double calculateFinalCost(InvoiceSolid invoice) {
	        return invoice.getCost() + calculateTax(invoice) - calculateDiscount(invoice);
	    }
}
