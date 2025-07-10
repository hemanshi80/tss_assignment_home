package com.tss.creational.abstractfactory.model;

public class Maruti implements ICar {

	@Override
	public void start() {
		System.out.println("Maruti Started!!");
		
	}

	@Override
	public void stop() {
		System.out.println("Maruti Stopped!!");
		
	}

}
