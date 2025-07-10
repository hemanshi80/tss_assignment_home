package com.tss.basics.selectionstatements;
import java.util.Scanner;

public class RideGameCalculator {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your height in cm :");
		float height = scanner.nextFloat();

		int charge = 0;

		if (height > 120) {
			System.out.println("Can Ride....");

			System.out.println("Enter your age:");
			int age = scanner.nextInt();

			System.out.println("Do you want a photo (true/false):");
			boolean photo = scanner.nextBoolean();

			if (age < 12) {
				charge = charge + 5;
				System.out.println("Total of ride  charge: " + charge);
			}

			else if ((age >= 12) && (age < 18)) {
				charge = charge + 7;
				System.out.println("Total of ride charge: " + charge);
			}

			else if (age >= 18) {
				charge = charge + 12;
				System.out.println("Total of ride charge: " + charge);
			}

			else if ((age >= 45) && (age < 55)) {
				charge = charge + 0;
			}

			else {
				charge = charge + 12;
				System.out.println("Total of ride charge: " + charge);
			}

			if (photo == true) {
				charge = charge + 3;
				System.out.println("Total charge of ride and photo :" + charge);
			}
		} else {

			System.out.println("Can't Ride!!!!");
		}

	}

}
