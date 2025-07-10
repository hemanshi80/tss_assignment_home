package com.tss.model;

public class ElectricityBill {
	
	private int apartmentNumber;
	private double unitsConsumed;
	private static float costPerUnit = 5;
	
	public ElectricityBill(int apartmentNumber, double unitsConsumed ) {
		this.apartmentNumber = apartmentNumber;
		this.unitsConsumed = unitsConsumed;
		
	}
	
	
	public int getApartmentNumber() {
		return apartmentNumber;
	}
	
	public double getUnitsConsumed() {
		return unitsConsumed;
	}
	public static float getCostPerUnit() {
		return costPerUnit;
	}
	
	
	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	
	public void setUnitsConsumed(double unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}
	
	public static void setCostPerUnit(float costPerUnit) {
		ElectricityBill.costPerUnit = costPerUnit;
	}
	
	
	
	public double calculateBillAmount () {
		double totalAmount = unitsConsumed * costPerUnit;
		System.out.println("The Electricity Bill Amount :" + totalAmount);
		return totalAmount;
	}
	
}
