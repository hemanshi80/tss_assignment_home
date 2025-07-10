package com.tss.test;

import java.util.Scanner;

public class MatrixTest {

	public static void main(String[] args) {
		
		int matrix[][] = new int[3][3];
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println ("Enter matrix element :" );
		
		
		System.out.println("Matrix is :");
		 for (int i =0; i<matrix[0].length; i++) {
			 for(int j=0; j<matrix[0].length; j++) {
				 System.out.print(matrix[i][j]);
				 
			 }
			 System.out.println(" ");
		 }
		 
		
		 
		 scanner.close();
	}
	
	

	public static void readMatrix(int matrix[][ , int i) {
		for (int i = 0; i<3; i++) {
			readRow(matrix , i , scanner);
		}
		
	public static void readRow(int matrix[][] , int i , Scanner scanner) {
		for(int j = 0; j<3; j++) {
			matrix[i][j] = scanner.nextInt();
		}
	}
	}
	}
