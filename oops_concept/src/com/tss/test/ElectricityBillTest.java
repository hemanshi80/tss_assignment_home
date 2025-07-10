package com.tss.test;

import java.util.Scanner;

import com.tss.model.ElectricityBill;

public class ElectricityBillTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of bills to be created :");
		int totalBill = scanner.nextInt();
		
		ElectricityBill[] electricityBill = new ElectricityBill[totalBill];
		int billCreated =0;

		while(true) {
			
			System.out.println("1. Create Bill");
			System.out.println("2. To Change Cost per Unit");
			System.out.println("3. Display Electricity Bill ");
			System.out.println("4. Quit");
			System.out.println("Enter your choice :");
			int option = scanner.nextInt();
			
			switch(option) {
			
			case 1:{
				readBillDetails(electricityBill, scanner, billCreated);
				billCreated++;
				break;
			}
			
			case 2:{
				System.out.println("change cost per unit :");
				float changedCost = scanner.nextFloat();
				ElectricityBill.setCostPerUnit(changedCost);
				break;
			}
			case 3:{
				System.out.println("Enter Apartment Number :");
				int apartmentNumber = scanner.nextInt();

				ElectricityBill bill = findApartmentNumber(electricityBill,apartmentNumber);
				if (bill != null) {
					double totalAmount = bill.calculateBillAmount();
					System.out.println("Electricity Bill is :" +  totalAmount);
				}	
				
				else {
					System.out.println("invalid");
				}
			}
			break;
			
			case 4:{
				System.out.println("Quitted...");
				return;
			}
			
			
			default:
			{
				System.out.println("Invalid Options");
			}
			
		}
		
	}
	}
	
	public static void readBillDetails(ElectricityBill[] electricityBill , Scanner scanner ,int billCreated ) {
		
		System.out.println("Enter Apartment Number :");
		int apartmentNumber = scanner.nextInt();
		
		System.out.println("Enter units consumed :");
		double unitsConsumed = scanner.nextDouble();
		
		electricityBill[billCreated] = new ElectricityBill(apartmentNumber, unitsConsumed);
		electricityBill[billCreated].calculateBillAmount();
	}
	
	private static ElectricityBill findApartmentNumber(ElectricityBill[] electricityBill,int apartmentNumber) {
		
		for(ElectricityBill bill : electricityBill) {
			if( apartmentNumber == bill.getApartmentNumber()) {
				return bill;
			}
		}
		return null;
	}


}
