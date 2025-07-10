package com.tss.model.Inheritance.model;

public class CarRental extends VehicleRental {

	
	
	public CarRental(int vehicleNumber, int rentPerDay, String fuelType) {
		super(vehicleNumber, rentPerDay, fuelType);
		
	}

	@Override
	public void calculateRent(int numberOfDays) {
		System.out.println("Rent of Car :" + numberOfDays*rentPerDay);	
	}

	public void display() {
		super.display();
	
	}
	
}
