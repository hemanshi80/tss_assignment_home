package com.tss.creational.factory.model;

import java.util.Random;

public class HeavyVehicle implements IVehicle {

	@Override
	public String generateLicenseNumber() {
		int number = new Random().nextInt(900000) + 100000;
		return "HV" + number;
	}
	

}
