package com.tss.structural.decorator.model;

public class OilChange extends CarServiceDecorator {

	public OilChange(ICarService carObj) {
		super(carObj);
	}

	@Override
	public double getCost() {
		return 500 + super.getCost();
	}
	
	

}
