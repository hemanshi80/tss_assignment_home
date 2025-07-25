package com.tss.creational.builder.model;

public class CarDirector {
	 private CarBuilder builder;

	    public CarDirector(CarBuilder builder) {
	        this.builder = builder;
	    }

	    public void constructCar() {
	        builder.buildEngine();
	        builder.buildWheels();
	        builder.buildAirConditioning();
	    }

	    public Car getCar() {
	        return builder.getCar();
	    }

}
