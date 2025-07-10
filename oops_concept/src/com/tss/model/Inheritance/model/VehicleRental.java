package com.tss.model.Inheritance.model;

public abstract class VehicleRental {

	private int vehicleNumber;
	protected int rentPerDay;
	private String fuelType = "";
	
	
	
	public VehicleRental(int vehicleNumber, int rentPerDay, String fuelType) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.rentPerDay = rentPerDay;
		this.fuelType = fuelType;
	}
	
	public abstract void calculateRent(int numberOfDays); 
	
	public void display() {
		System.out.println("Vehicle Number :"+ vehicleNumber);
		System.out.println("Rent Per Day :"+ rentPerDay);
		System.out.println("Fuel Type :"+ fuelType);
}
	
}
