package com.tss.creational.builder.test;

import com.tss.creational.builder.model.Car;
import com.tss.creational.builder.model.CarBuilder;
import com.tss.creational.builder.model.CarDirector;
import com.tss.creational.builder.model.SportsCarBuilder;

public class BuilderTest {

	public static void main(String[] args) {
		
		CarBuilder builder = new SportsCarBuilder();
        CarDirector director = new CarDirector(builder);
        director.constructCar();
        Car car = director.getCar();
        System.out.println(car);
	}

}
