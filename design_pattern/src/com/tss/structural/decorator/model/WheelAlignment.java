package com.tss.structural.decorator.model;

public class WheelAlignment extends CarServiceDecorator{

	public WheelAlignment(ICarService carObj) {
		super(carObj);
	}

	@Override
	public double getCost() {
		return 400 +  super.getCost();
	}

}
