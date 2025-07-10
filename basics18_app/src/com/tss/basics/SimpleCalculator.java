package com.tss.basics;
import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter first number:");
		int num1 = scanner.nextInt();
		System.out.println("Enter Second number:");
		int num2 = scanner.nextInt();
		
		
		addition(num1,num2);
		subtraction(num1,num2);
		multiplication(num1,num2);
		division(num1,num2);
	}
	
	private static void addition (int num1 , int num2)
	{
		int sum = num1 + num2;
		System.out.println("Sum = "+ sum);
	}

	private static void subtraction (int num1 , int num2)
	{
		int sub = num1 - num2;
		System.out.println("Sub = "+ sub);
	}
	
	private static void multiplication (int num1 , int num2)
	{
		int mul = num1 * num2;
		System.out.println("Mul = "+ mul);
	}
	
	private static void division(int num1 , int num2)
	{
		int div = num1 / num2;
		System.out.println("Div = "+ div);
	}
}
