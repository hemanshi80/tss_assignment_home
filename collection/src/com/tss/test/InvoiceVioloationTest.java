package com.tss.test;

import com.tss.model.InvoiceViolation;

public class InvoiceVioloationTest {

	public static void main(String[] args) {
		  InvoiceViolation inv = new InvoiceViolation(1, "Smartphone", 30000.0, 10.0);

	        System.out.println("Invoice");
	        System.out.println("ID: " + inv.getId());
	        System.out.println("Description: " + inv.getDescription());
	        System.out.println("Cost: ₹" + inv.getCost());
	        System.out.println("Tax (" + InvoiceViolation.TAX_PERCENT + "%): ₹" + inv.calculateTax());
	        System.out.println("Discount (" + inv.getDiscountPercent() + "%): ₹" + inv.calculateDiscount());
	        System.out.println("Final Amount: ₹" + inv.calculateFinalCost());

	        System.out.println("\nPrinting full invoice:\n");
	        inv.print();  
	}

}
