package com.tss.basics.array;

import java.util.Scanner;

public class CharacterShift {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = scanner.nextLine();

        System.out.print("Enter shift value : ");
        int shift_number = scanner.nextInt();

        String output = shiftCharacters(input, shift_number);
        System.out.println("Shifted Output: " + output);
		
	}

	private static String shiftCharacters(String input, int number) {
		
		char result[] = new char[input.length()];
		for (int i= 0; i<input.length(); i++) {
			char character =input.charAt(i);
			
			if(character >= 'a' && character<='z') {
				result[i] = (char) ((character - 'a' + number + 26)%26 + 'a');
			}
			
			else if(character >= 'A' && character <= 'Z') {
				result[i] = (char) ((character - 'A' + number + 26)%26 + 'A');
			}
			
			else {
				result[i] = character;
			}
			
		}
		return new String(result);	
	}
}
