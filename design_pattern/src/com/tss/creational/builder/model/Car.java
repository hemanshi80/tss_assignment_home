package com.tss.creational.builder.model;

public class Car {

	private String engine;
	private int wheels;
	private boolean airConditioning;

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public void setAirConditioning(boolean airConditioning) {
		this.airConditioning = airConditioning;
	}

	@Override
	public String toString() {
		return "Car [engine=" + engine + ", wheels=" + wheels + ", airConditioning=" + airConditioning + "]";
}
}