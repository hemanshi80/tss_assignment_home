package com.tss.basics;

import java.util.Scanner;

public class DistanceBetweenTwoPoints {

	public static void main(String[] args) {
	

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter first point of x - x1:");
		int x1 = scanner.nextInt();
		
		System.out.println("Enter Second point of x - x2:");
		int x2 = scanner.nextInt();
		
		System.out.println("Enter first point of y - y1:");
		int y1 = scanner.nextInt();
		
		System.out.println("Enter Second point of y - y2:");
		int y2 = scanner.nextInt();
		
		calculateDistanceBetweenTwoPoints(x1,x2,y1,y2);
	
	}

	private static void calculateDistanceBetweenTwoPoints(int x1, int x2 , int y1 , int y2)
	{
		double distance = Math.sqrt(Math.pow((x1-x2),2)+ Math.pow((y1-y2),2));
		System.out.println("Distance between two points :" +distance);
	}
}
