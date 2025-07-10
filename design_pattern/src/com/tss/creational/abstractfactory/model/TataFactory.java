package com.tss.creational.abstractfactory.model;

import com.tss.creational.factory.model.ICar;

public class TataFactory implements ICarFactory{

	@Override
	public ICar makeCars() {
		
		return new Tata();
	}

}
