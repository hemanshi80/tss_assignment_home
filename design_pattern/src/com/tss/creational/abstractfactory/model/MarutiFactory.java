package com.tss.creational.abstractfactory.model;

import com.tss.creational.factory.model.CarType;
import com.tss.creational.factory.model.ICar;

public class MarutiFactory implements ICarFactory {

	@Override
	public ICar makeCars() {
		return (ICar) new Maruti();

	}

}
