package com.tss.test.exception_handling;

import java.util.Scanner;

import com.tss.exception.InsufficientWaterException;
import com.tss.exception.OverfillException;
import com.tss.model.exception_handling.WaterDispenser;

public class WaterDispenserTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		WaterDispenser waterDispense = new WaterDispenser();
		
		while(true) {
			
				
				System.out.println("-------------------Water Dispenser------------------");
				System.out.println("1. Fill Water");
				System.out.println("2. Dispense Water");
				System.out.println("3. Display Current Water Level");
				System.out.println("4. Quit");
				System.out.println("Enter your choice :");
				int option = scanner.nextInt();
				
				switch(option) {
				
				case 1: 
					System.out.print("Enter liters to fill water (in liters)");
					double fill = scanner.nextDouble();
					try {
					waterDispense.fillWater(fill);
					
					}
					catch(OverfillException e) {
						System.out.println(e.getMessage());
					}
					finally {
						waterDispense.displayCurrentWaterLevel();
					}
					break;
				
				case 2:
					System.out.println("Enter liters to dispense water (in liters)");
					double waterDispensed = scanner.nextDouble();
					try {
					waterDispense.dispenseWater(waterDispensed);
					}
					catch(InsufficientWaterException e) {
						System.out.println(e.getMessage());
					}
					finally{
						waterDispense.displayCurrentWaterLevel();
					}
					break;
				case 3:
					waterDispense.displayCurrentWaterLevel();
					break;
					
				case 4: 
					System.out.println("Thanks for drinking and filling water !!");
					return;
					
				default :
				{
					System.out.println("Invalid Input");
				}
				}
			
		}
	}

}
