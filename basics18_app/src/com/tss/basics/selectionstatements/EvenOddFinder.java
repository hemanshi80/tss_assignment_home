package com.tss.basics.selectionstatements;

import java.util.Scanner;

public class EvenOddFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a Number :");
		int number = scanner.nextInt();
		
		if (number%2==0)
		{
			System.out.println("The entered number is even :" +number);
		}
		
		System.out.println("The entered number is odd :" +number);
		
	}

}
