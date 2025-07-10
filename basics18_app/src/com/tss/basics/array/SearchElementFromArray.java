package com.tss.basics.array;

import java.util.Scanner;

public class SearchElementFromArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size of array:");
		int size = scanner.nextInt();
		int array []= new int [size];
		
		for (int i=0; i<size; i++) {
		System.out.println("Enter elements in array:" + i);
		array[i] = scanner.nextInt();
		
		}
		
		System.out.println("Enter the element to search: ");
		int search = scanner.nextInt();
		for (int i=0; i<size; i++) {
			
			if(array[i] == search) {
				System.out.println("The element is at index :" + i);
			}
			}
		
	}

}
