package com.tss.basics.loopingstatements;

import java.util.Scanner;

public class ArmstrongNumberUsingWhileLoop {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number  :");
		int number = scanner.nextInt();
		
		int temp = number;
		int len_of_number = String.valueOf(number).length();
		int sum = 0;
		
		while(number>0)
		{
			int digit = number % 10;
			sum += Math.pow(digit, len_of_number);
			number = number/10;
			
		}
		
		if(sum == temp) {
			System.out.println("Number is armstrong");
		}
		else {
			System.out.println("Number is not a armstrong");
		}
		
	}

}
