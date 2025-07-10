package com.tss.basics.array;

import java.util.Scanner;

public class MultiplicationOfTwoMatrices {

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
		
		System.out.println ("Enter number of rows :" );
		int rows = scanner.nextInt();
		
		System.out.println ("Enter number of columns :" );
		int cols = scanner.nextInt();
		
		int matrix[][] = new int[rows][cols];
		
		System.out.println ("Enter first matrix element :" );
		
		readMatrix(matrix , scanner ,rows,cols);
		
		
		int matrix_2[][] = new int[rows][cols];
		System.out.println ("Enter second matrix element :" );
		
		readMatrix(matrix_2,scanner , rows , cols);
		
		
		multiplicationOfTwoMatrix (matrix,matrix_2,rows,cols);
		
		
		scanner.close();
		
}

	private static void printMultiplicationOutput(int[][] result, int rows , int cols) {
		 for (int i = 0; i<rows; i++) {
				for(int j = 0; j<cols; j++) {
					System.out.print(result[i][j]);
				}
				
				System.out.println(" ");
		 }
		
		
	}

	private static void multiplicationOfTwoMatrix(int[][] matrix,int[][] matrix_2,int rows , int cols) {
		int multiplicationOfTwoArray[][] = new int [rows][cols];
		for (int i = 0; i<rows; i++) {
			for(int j = 0; j<cols; j++) {
				for (int k =0; k<cols; k++) {
					multiplicationOfTwoArray[i][j] += matrix[i][k] * matrix_2[k][j];
				}
			}
			
		}
		printMultiplicationOutput(multiplicationOfTwoArray,rows, cols);

		
	}

	private static void readMatrix(int[][] matrix,Scanner scanner , int rows , int cols) {

		for (int i = 0; i<rows; i++) {
			for(int j = 0; j<cols; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		
	}
}