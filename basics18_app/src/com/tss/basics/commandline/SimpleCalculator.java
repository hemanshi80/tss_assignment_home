package com.tss.basics.commandline;

public class SimpleCalculator {

	public static void main(String[] args) {
		
		int num1 = Integer.parseInt(args[0]);
		
		int num2 = Integer.parseInt(args[1]);
		
		
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
