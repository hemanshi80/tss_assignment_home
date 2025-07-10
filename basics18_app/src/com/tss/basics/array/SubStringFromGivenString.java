package com.tss.basics.array;
import java.util.Scanner;
public class SubStringFromGivenString {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the first string (words to be precise) :");
		String first_string =  scanner.nextLine();
		
		System.out.println("Enter a sub string to find from entered string:");
		String second_string =  scanner.nextLine();
		
		System.out.println(isString(first_string , second_string));
	
			 
	}
	private static boolean isString(String first_string ,String second_string ) {
		char original_input[] = first_string.toCharArray();
		char find_string[] = second_string.toCharArray();
		
		if (find_string.length == 0)return true;
		if (find_string.length > original_input.length)return false;
		
		
		for (int i = 0; i<= original_input.length - find_string.length; i++) {
			int j;
			for ( j =0; j<find_string.length; j++) {
				if (original_input[i+j] != find_string[j]) {
					break;
				}
			}
			
			if(j == find_string.length) {
				return true;
			}
		}
		return false;
	}
}
