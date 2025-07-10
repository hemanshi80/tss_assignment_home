package com.tss.basics.selectionstatements;

import java.util.Scanner;

public class BillingChargeCalculation {

public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter meter unit readings  :");
		float units = sc.nextFloat();
		
		waterBillReadings(units);

	}
	private static void waterBillReadings(float units)
	{
		int meter_charge = 75;
		float charge;	
		float total_water_bill;
		if(units<=100)
		{
			charge = (units*5);
		}
		else
		{
			if(units<=250)
			{
				float extra_unites = units - 100;
				charge = (100*5) + extra_unites*10;
			}
			else
			{
				float extra_unites = units - 250;
				charge =(100*5) + (150 * 10) + extra_unites*20;
			}
		}
		
		total_water_bill = meter_charge + charge;
		System.out.println("Total Water bill readings: "+total_water_bill);
		
	}
}