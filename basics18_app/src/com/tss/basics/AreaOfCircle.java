package com.tss.basics;

import java.util.Scanner;

public class AreaOfCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Radius :");
		float radius = scanner.nextFloat();
		
		areaOfCircle(radius);
		
	}

	private static void areaOfCircle(float radius)
	{
		double area = 3.14 * radius * radius;
		
		System.out.println("Area of Circle : " + area);
		
	}
	
}
