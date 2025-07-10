package com.tss.basics.loopingstatements;

import java.util.Scanner;

public class PerfectNumberUsingWhileLoop {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number  :");
		int number = scanner.nextInt();
		
		int i = 1;
		int sum =0;
		
		while(i <= number/2) {
			if (number% i == 0) {
				sum +=i;
			}
				i++;
	}
		
		if (sum == number)
		{
			System.out.println("It is a Perfect Number");
		}
		else {
			System.out.println("It is not a Perfect Number");
		}
		}

}
