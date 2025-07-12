package com.tss.creational.builder.model;

public interface CarBuilder {

	void buildEngine();
	void buildWheels();
	void buildAirConditioning();
	Car getCar();
}
