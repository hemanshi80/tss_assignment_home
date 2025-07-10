package com.tss.basics.array;

import java.util.Scanner;

public class MaximumElementOfArray {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size of array:");
		int size = scanner.nextInt();
		int array []= new int [size];
		int max = 0;
		
		for (int i=0; i<size; i++) {
		System.out.println("Enter elements in array:" + i);
		array[i] = scanner.nextInt();
		if (max < array[i]) {
			max = array[i];
		}
		}
		
		System.out.print("The Maximum Element is : " + max);
		
		

	}

}
