package com.tss.exception;

public class OverfillException extends RuntimeException {

	private double liters;

	public OverfillException(double liters) {
		super();
		this.liters = liters;
	}
	
	public String getMessage() {
		return "Tank reached its maximum limit !! Water Over Filled ";
	}
}
