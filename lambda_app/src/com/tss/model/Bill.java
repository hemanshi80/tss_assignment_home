package com.tss.model;

public class Bill {
	
	private String itemName;
	private double basePrice;
	private double tax;
	private double shipping;
	private double finalAmount;
	
	public Bill(String itemName, double basePrice, double tax, double shipping, double finalAmount) {
		super();
		this.itemName = itemName;
		this.basePrice = basePrice;
		this.tax = tax;
		this.shipping = shipping;
		this.finalAmount = finalAmount;
	}

	@Override
	public String toString() {
		return "--------Total Bill--------" +"\n itemName= " + itemName + " \n basePrice= " + basePrice + "\n tax=" + tax + "\n shipping=" + shipping
				+ "\n finalAmount=" + finalAmount + " ";
	}

}
