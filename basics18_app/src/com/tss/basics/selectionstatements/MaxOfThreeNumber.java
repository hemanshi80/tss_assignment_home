package com.tss.basics.selectionstatements;

import java.util.Scanner;

public class MaxOfThreeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first  Number :");
		int number1 = scanner.nextInt();
		
		System.out.println("Enter second Number :");
		int number2 = scanner.nextInt();
		
		maxOfTwoNumbers(number1 , number2);
	}

	private static void maxOfTwoNumbers(int number1 , int number2)
	{
		if (number1 > number2)
		{
			System.out.println(number1+ "is greater than "+ number2);
		}
		else
		{
			System.out.println(number2+ "is greater than" +number1);
		}
	}
	
}
