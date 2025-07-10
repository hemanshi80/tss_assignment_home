package com.tss.basics.array;

import java.util.Scanner;

public class ArrayBasic {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number into array:");
		
		int array[] = new int [5];
		
		for (int i = 1 ; i < array.length ; i++) {
			
			System.out.print(array[i] + " ");
		}
			
		
	}
	

}
