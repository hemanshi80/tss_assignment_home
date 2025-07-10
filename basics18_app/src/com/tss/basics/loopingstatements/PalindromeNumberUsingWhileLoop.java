package com.tss.basics.loopingstatements;

import java.util.Scanner;

public class PalindromeNumberUsingWhileLoop {

	public static void main(String[] args) {
		
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
		if (temp_number == rev) {
		System.out.println("Number is Palindrome :" );
		}
		else {
		System.out.println("Number is not Palindrome :" );
		}


	}

}
