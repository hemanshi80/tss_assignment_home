package com.tss.basics.selectionstatements;

import java.util.Random;

public class FactorialOfNumber {

	public static void main(String[] args) {
		Random random = new Random();
		int random_number = random.nextInt(5);

	System.out.println("Generated number : " + random_number);
		
		calculateFactorial(random_number);
	}

	private static void calculateFactorial(int random_number) {
		int factorial = 1;
		for(int i = 1; i <= random_number; i++) {
			factorial *= i;
		}
		System.out.println("Factorial : " + factorial);
	}

}
