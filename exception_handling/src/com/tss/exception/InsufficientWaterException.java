package com.tss.exception;

public class InsufficientWaterException extends RuntimeException{

	private double liters;

	public InsufficientWaterException(double liters) {
		super();
		this.liters = liters;
	}

	public String getMessage() {
		return "Insufficient Water in Tank !! Reached below the capacity. ";
	}
}
