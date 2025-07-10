package com.tss.basics;

import java.util.Scanner;

public class swapvariableusingthird {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter first number:");
		int num1 = scanner.nextInt();
		System.out.println("Enter Second number:");
		int num2 = scanner.nextInt();
		
		
		System.out.println("Before Swaping  variable :");
		System.out.println("Number1 :" + num1);
		System.out.println("Number2 :"+num2 );
		
		swapvariableusingthird(num1 , num2);
		swapvariablewithoutthird(num1 , num2);
		
		
	}

	private static void swapvariableusingthird(int num1 ,int  num2)
	{
		int temp =0;
		temp = num1;
		num1 = num2;
		num2 = temp;
		
		System.out.println("After Swaping with temp variable :");
		System.out.println("Number1 :" + num1);
		System.out.println("Number2 :"+num2 );
		
	}
	
	private static void swapvariablewithoutthird(int num1 ,int  num2)
	{
		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;
		
		System.out.println("After Swaping without temp variable :");
		System.out.println("Number1 :" + num1);
		System.out.println("Number2 :"+num2 );
		
	}
	
}
