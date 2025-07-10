package com.tss.basics.array;

import java.util.Scanner;

public class AdditionOfTwoMatrices {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println ("Enter number of rows :" );
		int rows = scanner.nextInt();
		
		System.out.println ("Enter number of columns :" );
		int cols = scanner.nextInt();
		
		int matrix[][] = new int[rows][cols];
		
		System.out.println ("Enter matrix element :" );
		
		for (int i = 0; i<rows; i++) {
			for(int j = 0; j<cols; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		
		int matrix_2[][] = new int[rows][cols];
		System.out.println ("Enter second matrix element :" );
		
		for (int i = 0; i<rows; i++) {
			for(int j = 0; j<cols; j++) {
				matrix_2[i][j] = scanner.nextInt();
			}
		}
		 
		 System.out.println("Multiplication of two matrix is :");
		 int sumOfTwoArray[][] = new int [rows][cols];
		 for (int i = 0; i<rows; i++) {
				for(int j = 0; j<cols; j++) {
					sumOfTwoArray[i][j] = matrix[i][j] + matrix_2[i][j];
					System.out.print(sumOfTwoArray[i][j]);
				}
				 System.out.println(" ");
	
		 }
		 
		 scanner.close();

	}

}
