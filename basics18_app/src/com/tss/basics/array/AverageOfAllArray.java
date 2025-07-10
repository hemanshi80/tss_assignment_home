package com.tss.basics.array;

import java.util.Scanner;

public class AverageOfAllArray {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size of array:");
		int size = scanner.nextInt();
		int array []= new int [size];
		int total = 0;
		
		for (int i=0; i<size; i++) {
		System.out.println("Enter elements in array:" + i);
		array[i] = scanner.nextInt();
		total = total + array[i];
		}
		
		System.out.print("The average of elements of array is " + total/size);
		
	}

}
