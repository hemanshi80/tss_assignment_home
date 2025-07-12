package com.tss.structural.adapter.model;

public class Chocolate implements IItems{

	String name;
	double price;
	
	@Override
	public String getItemName() {
		
		return name;
	}

	@Override
	public double getItemPrice() {
		
		return price;
	}

	public Chocolate(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	

}
