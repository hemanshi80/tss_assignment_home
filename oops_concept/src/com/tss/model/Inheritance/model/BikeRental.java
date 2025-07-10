package com.tss.model.Inheritance.model;

public class BikeRental extends VehicleRental {

	public BikeRental(int vehicleNumber, int rentPerDay, String fuelType) {
		super(vehicleNumber, rentPerDay, fuelType);
	
	}

	@Override
	public void calculateRent(int numberOfDays) {
	if(numberOfDays > 5) {
		System.out.println("Rent of Bike is :" + ((numberOfDays*rentPerDay)*0.9));
		return;
	}
	System.out.println("Rent of Bike is:" + (numberOfDays*rentPerDay));
	
	}

	public void display() {
		super.display();
	
	}
	
}
