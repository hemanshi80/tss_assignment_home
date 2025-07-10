package com.tss.model.Inheritance.model;

public class TruckRent extends VehicleRental{

	public TruckRent(int vehicleNumber, int rentPerDay, String fuelType) {
		super(vehicleNumber, rentPerDay, fuelType);
	}

	@Override
	public void calculateRent(int numberOfDays) {
		System.out.println("Truck Rent is :" + (numberOfDays*rentPerDay) + 500);	
	}

	public void display() {
		super.display();
	
	}
	
}
