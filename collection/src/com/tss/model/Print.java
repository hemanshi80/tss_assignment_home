package com.tss.model;

public class Print {
	
	 public void print(InvoiceSolid invoice, Calculate calculator) {
	        System.out.printf("%-5s %-20s %-10s %-10s %-20s %-15s%n",
	                "ID", "Description", "Amount", "Tax(%)", "Discount Percentage", "Final Amount");
	        System.out.println("----------------------------------------------------------------------------");
	        System.out.printf("%-5d %-20s %-10.2f %-10.2f %-20.2f %-15.2f%n",
	                invoice.getId(),
	                invoice.getDescription(),
	                invoice.getCost(),
	                Calculate.TAX_PERCENT,
	                invoice.getDiscountPercent(),
	                calculator.calculateFinalCost(invoice));
	    }

}
