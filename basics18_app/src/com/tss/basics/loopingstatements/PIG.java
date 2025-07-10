package com.tss.basics.loopingstatements;

import java.util.Random;
import java.util.Scanner;

public class PIG {

	public static void main(String[] args) {

		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		int turn = 1;
		int points = 0;

		while (true) {
			System.out.println("Your Turn:" + turn);
			System.out.println("Roll or Hold ? (r/h)  :");
			String action = scanner.nextLine();

			while (action.equalsIgnoreCase("r")) {
				int roll_dice = random.nextInt(6) + 1;
				System.out.println("You got number :" + roll_dice);

				if (roll_dice == 1) {
					System.out.println("Sorry!!! , you rolled 1 \n Try next time \n Game Over");
					points = 0;
					System.out.println("Your Score " + points);
					scanner.close();
					return;
				}

				points = points + roll_dice;
				System.out.println("Your Score " + points);
				System.out.println("Roll or Hold ? (r/h)  :");
				String action1 = scanner.nextLine();

				if (action1.equalsIgnoreCase("r")) {
					action = "r";	
				}
				else {
					System.out.println("You chose to hold. Your Score: " + points);
//					scanner.close();
//					return;
					break;
				}
				if (points >= 20) {
					System.out.println("YEAHhhh you won the game with points " + points + " and you used " + turn + "turns.");
					scanner.close();
					return;
				}
			}

			turn++;
			System.out.println("End of Turn. Current score: " + points);
			System.out.println("---------------------------------------");
		}

	}

}
