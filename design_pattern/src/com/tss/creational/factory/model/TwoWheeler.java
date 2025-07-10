package com.tss.creational.factory.model;

import java.util.Random;

public class TwoWheeler implements IVehicle {

	@Override
	public String generateLicenseNumber() {
		int number = new Random().nextInt(9000) + 1000;
		return "TW" + number;
		
	}

	
}
