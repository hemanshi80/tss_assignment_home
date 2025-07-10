package com.tss.basics.array;

import java.util.Scanner;

public class ArrayMatrix {

	public static void main(String[] args) {
		int matrix[][] = new int[3][3];
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println ("Enter matrix element :" );
		
		for (int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		
		System.out.println("Matrix is :");
		 for (int i =0; i<matrix[0].length; i++) {
			 for(int j=0; j<matrix[0].length; j++) {
				 System.out.print(matrix[i][j]);
				 
			 }
			 System.out.println(" ");
		 }
		 
		
		 
		 scanner.close();
	}
	
	
	
}
