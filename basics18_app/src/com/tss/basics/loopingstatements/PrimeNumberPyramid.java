package com.tss.basics.loopingstatements;

import java.util.Scanner;

public class PrimeNumberPyramid {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of rows  :");
		int rows_count = scanner.nextInt();
		
		int initialize = 2;
		
		for (int i = 1; i<rows_count; i++)
		{
			for (int j =0; j<=i; j++)
			{
				while(!isPrime(initialize)) {
					initialize++;
				}
				System.out.print(initialize + " ");
				initialize++;
			}
			
			System.out.println ();
			
		}
		
		
	}
	
	private static boolean isPrime(int num) {
		for(int i = 2; i*i <= num ; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	
}
