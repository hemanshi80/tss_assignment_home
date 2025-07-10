package com.tss.model.Inheritance.model;

public class ElectricCar extends Car {

	private int batteryLevel ;

	public ElectricCar(String model, int year, int price, int numberOfDoors, int batteryLevel) {
		super(model, year, price, numberOfDoors);
		this.batteryLevel = batteryLevel;
	}
	
	public void chargeBattery() {
		System.out.println("Battery's Charging");
	}
	
	public  void displayBatteryStatus() {
		System.out.println("Battery's Status :" + batteryLevel);
	}
	
}
