package com.tss.basics.loopingstatements;

import java.util.Scanner;

public class SumOfDigitsUsingWhileLoop {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number  :");
		int number = scanner.nextInt();
		int sum = 0;
		while (number > 0) {
			
			int dig = number % 10;
			sum = sum + dig;
			number = number / 10;
		}
		
		System.out.println("The sum of number is:" + sum);
	}

}
