package com.tss.model.Inheritance.test;

import java.util.Scanner;

import com.tss.model.Inheritance.model.BikeRental;
import com.tss.model.Inheritance.model.CarRental;
import com.tss.model.Inheritance.model.TruckRent;

public class VehicleRentalTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Enter number of days :" );
		int days = scanner.nextInt();
		
		BikeRental bike = new BikeRental(2004 , 500 , "Petrol");
		bike.display();
		bike.calculateRent(days);
		
		
		CarRental car = new CarRental(2005 , 1500 , "Disel");
		car.display();
		car.calculateRent(days);
		
		TruckRent truck = new TruckRent(2006 , 400 , "Petrol");
		truck.display();
		truck.calculateRent(days);
		
	}

}
