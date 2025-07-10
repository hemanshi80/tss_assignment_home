package com.tss.model.Inheritance.test;

import com.tss.model.Inheritance.model.ElectricCar;

public class ElectricCarTest {

	public static void main(String[] args) {
		
		ElectricCar car = new ElectricCar("Verna",2018 ,80000 , 4 , 80 );
		car.displayInfo();
		car.displayBatteryStatus();
		car.lockDoors();
		car.unlockDoors();

	}

}
