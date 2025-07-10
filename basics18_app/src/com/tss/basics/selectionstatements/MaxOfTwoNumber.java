package com.tss.basics.selectionstatements;

import java.util.Scanner;

public class MaxOfTwoNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first  Number :");
		int number1 = scanner.nextInt();
		
		System.out.println("Enter second Number :");
		int number2 = scanner.nextInt();
		
		System.out.println("Enter third Number :");
		int number3 = scanner.nextInt();
		
		maxOfTwoNumbers(number1 , number2 , number3);
	}

	private static void maxOfTwoNumbers(int number1 , int number2,int number3)
	{
		if ((number1 > number2) && (number1 > number3) )
		{
			System.out.println(number1 + " is greater ");
		}
		else if ((number2 > number1) && (number2 > number3) )
		{
			System.out.println(number2 + " is greater");
		}
		
		else
		{
			System.out.println(number3 + " is greater");
		}
	}
	
}
