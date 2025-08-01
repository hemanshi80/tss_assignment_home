package com.tss.creational.factory.test;

import com.tss.creational.factory.model.CarFactory;
import com.tss.creational.factory.model.CarType;
import com.tss.creational.factory.model.ICar;

public class CarFactoryTest {

	public static void main(String[] args) {
		
		CarFactory factory = new CarFactory();
		ICar Maruti = factory.makeCars(CarType.Maruti);
		
		Maruti.start();
		Maruti.stop();
		
		ICar Mahindra = factory.makeCars(CarType.Mahindra);
		
		Mahindra.start();
		Mahindra.stop();
		
		ICar Tata = factory.makeCars(CarType.Tata);
		
		Tata.start();
		Tata.stop();

	}

}
