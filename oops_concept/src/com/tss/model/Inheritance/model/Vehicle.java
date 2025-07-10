package com.tss.model.Inheritance.model;

public class Vehicle {

	private String model = "";
	private int year ;
	private int price;
	
	
	public Vehicle(String model, int year, int price) {
		super();
		this.model = model;
		this.year = year;
		this.price = price;
	}
	
	public  void startEngine() {
		System.out.println("Enginee Started");
	}
	
	public void stopEngine() {
		System.out.println("Enginee Stopped!!!");
	}
	
	public  void displayInfo() 
	{
		System.out.println("Model :"+model);
		System.out.println("Price :"+price);
		System.out.println("Year :"+year);
	}
	
	
	
	
}
