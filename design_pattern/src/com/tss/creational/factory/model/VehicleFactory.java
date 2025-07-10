package com.tss.creational.factory.model;

public class VehicleFactory {
	
	public static IVehicle getVehicle(VehicleType type) {
		if (type == null)
			return null;
		
		switch(type) {
		case TwoWheeler:
			return new TwoWheeler();
			
		case FourWheeler:
			return new FourWheeler();
			
		case HeavyVehicle:
			return new HeavyVehicle();
		
		default:
			return null;
		}
		
			
	}

}
