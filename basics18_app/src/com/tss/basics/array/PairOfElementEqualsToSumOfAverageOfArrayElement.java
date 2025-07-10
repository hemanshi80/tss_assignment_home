package com.tss.basics.array;

import java.util.Scanner;

public class PairOfElementEqualsToSumOfAverageOfArrayElement {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		System.out.print("Enter array size :");
		int size = scanner.nextInt();
		int arr[] = new int[size];
		int sum = 0;
		
		for (int i = 0; i<arr.length ;i++  ) {
			System.out.println("Enter array elements : "+ i);
			arr[i] = scanner.nextInt();
			sum += arr[i];		
		}
		
		int average_of_element = sum/arr.length;
		
		System.out.println("The average of array element is : " + average_of_element );
		
		if(pairSumNumber(average_of_element , size)) {
			System.out.println("True ,  the pair exisit as the average");
		}
		else
			System.out.println("False");
	}
	
	private static boolean pairSumNumber(int average_of_element , int n) {
		for(int i =0; i<n-1; i++) {
			for(int j=0; j<i+1; j++) {
				if (i+j == average_of_element) {
					return true;
				}
			}
		}
		return false;
	}

}
