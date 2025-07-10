package com.tss.basics.loopingstatements;

import java.util.Scanner;

public class PrimeNumberUsingWhileLoop {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number  :");
		int number = scanner.nextInt();
		boolean numberisnotprime = false;
		int i = 2;
		while(i >= number/2) {
			if (number% i == 0) {
				numberisnotprime = true;
				break;
			}
				i++;
					
		}
		if (numberisnotprime) {
			System.out.println("Number is prime.");
		}
		else {
		System.out.println("Number is not prime.");
		}
	}

}
