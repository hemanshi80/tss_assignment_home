package com.tss.test;

import java.util.Scanner;

public class EvenOddTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Enter a number :");
		int num1 = scanner.nextInt();
		
		
		if(num1%2 != 0) {
			
					System.out.println("the number is odd");
			return;
		}
		
		System.out.println("the number is even");
		
		

	}

}
