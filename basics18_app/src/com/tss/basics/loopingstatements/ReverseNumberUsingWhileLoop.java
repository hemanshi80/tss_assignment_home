package com.tss.basics.loopingstatements;

import java.util.Scanner;

public class ReverseNumberUsingWhileLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number  :");
		int number = scanner.nextInt();
		
		int temp_number = number;
		int rev = 0;
		
		while(number > 0) {
		int dig = number % 10;
		rev = (rev*10) + dig;
		number = number / 10;
		}
		System.out.println("Reverse of an number :" + rev);
		
	}
	

}
