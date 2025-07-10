package com.tss.basics.selectionstatements;

import java.util.Scanner;

public class TreasureIslandGame {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your move to march forward (right/left) :");
		String move = scanner.next();

		if (move.equalsIgnoreCase("left")) {
			System.out.println("Enter the next move (swim / wait)");
			String move2 = scanner.next();

			if (move2.equalsIgnoreCase("wait")) {
				System.out.println("Enter which door (red / blue / yelow)");
				String move3 = scanner.next();

				if (move3.equalsIgnoreCase("yellow")) {
					System.out.println("You win");
				} else if (move3.equalsIgnoreCase("red")) {
					System.out.println("Burned by fire. \n Game over");
				} else if (move3.equalsIgnoreCase("blue")) {
					System.out.println("Eaten by beasts. \n Game over");
				} else {
					System.out.println("Game over");
				}
			} else {
				System.out.println("Attacked by trout. \n Game Over");
			}
		} else {
			System.out.println("Fall into a hole.\n Game over.");
		}
	}
}
