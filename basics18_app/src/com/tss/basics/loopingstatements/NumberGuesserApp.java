package com.tss.basics.loopingstatements;
import java.util.Random;
import java.util.Scanner;

public class NumberGuesserApp {

	public static void main(String[] args) {
		
		Random random = new Random();
		int random_number = random.nextInt(100)+1;
	
		Scanner scanner = new Scanner(System.in);
		
		int maximum_round =5;
		
		while ( maximum_round >= 0) {
			System.out.println("Guess the digit (between 1-100) :");
			int guess_number = scanner.nextInt();
			
			if((guess_number < 1) || (guess_number > 100)) {
				System.out.println("Invalid number \n Enter number between 1-100");
			}
			if (guess_number < random_number) {
				System.out.println("Sorry too low!!");
				System.out.println("Now Attempts left : " + (maximum_round - 1));
				
			}
			else if (guess_number > random_number) {
				System.out.println("Sorry too High!!");
				System.out.println("Now Attempts left : " + (maximum_round - 1));
			
			}
			else {
				System.out.println("You Gussed it Correct");
				System.out.println("You won in  : " + (6 - maximum_round )+ " attempt");
				break;
			}
			maximum_round--;
			}
			
		}
		
		
	}


