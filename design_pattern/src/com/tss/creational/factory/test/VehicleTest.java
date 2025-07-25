package com.tss.creational.factory.test;

import java.util.Scanner;

import com.tss.creational.factory.model.IVehicle;
import com.tss.creational.factory.model.VehicleFactory;
import com.tss.creational.factory.model.VehicleType;

public class VehicleTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Vehicle Type (TwoWheeler , FourWheeler , HeavyVehicle) :");
		String type = scanner.nextLine();
		
		try {
			VehicleType vtype = VehicleType.valueOf(type);
			IVehicle vehicle = VehicleFactory.getVehicle(vtype);
			
			if (vehicle != null) {
				String vehiclePlate = vehicle.generateLicenseNumber();
				System.out.println("Vehicle Number Plate is :" + vehiclePlate);
			}
			
			else {
				System.out.println("Invalid Vehicle Type Input!!!");
		}
		}
		
		catch(Exception e) {
			System.out.println("Vehicle Type Invalid!");
			
		}
   }
}
