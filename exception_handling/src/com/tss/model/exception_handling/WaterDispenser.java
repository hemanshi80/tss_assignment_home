package com.tss.model.exception_handling;

import com.tss.exception.InsufficientWaterException;
import com.tss.exception.OverfillException;

public class WaterDispenser {

	private double currentWaterLevel;
	private double maxWaterLevel = 100;
	
	public void fillWater (double liters) throws OverfillException
	{
		if ((currentWaterLevel + liters) > maxWaterLevel) {
			throw new OverfillException(liters);
		}
		currentWaterLevel = currentWaterLevel + liters;
		System.out.println("Water filled : "+liters + " liters");
	}
	
	public void dispenseWater(double liters) throws InsufficientWaterException {
		
		if (liters >currentWaterLevel) {
			throw new InsufficientWaterException(liters);
		}
		currentWaterLevel = currentWaterLevel - liters;
		System.out.println("Water Dispensed : " + liters + " liters");
	}
	
	public void displayCurrentWaterLevel () {
		
		System.out.println("The current water level is :" + currentWaterLevel);
	}
}
