package com.tss.basics;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Principal Amount:");
		double principal_amt = scanner.nextInt();
		
		System.out.println("Enter Rate of Interest:");
		double rate_of_interest = scanner.nextInt();
		
		System.out.println("Enter Duration of Interest:");
		double duration = scanner.nextInt();
		
		SimpleInterestCalc(principal_amt , rate_of_interest , duration);
		

	}

	private static void SimpleInterestCalc(double principal_amt , double rate_of_interest , double duration)
	{
	double simple_interest = (principal_amt * rate_of_interest* duration)/100;
	
	System.out.println("Simple Interest :" + simple_interest);
	}
}
