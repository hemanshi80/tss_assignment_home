package com.tss.basics.selectionstatements;

import java.util.Scanner;

public class MonthlySeasonCheck {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Month Name in 3 letters:");
		String month = scanner.nextLine();
		
		switch(month.toLowerCase()) {
		
		case "nov" : case "dec" : case  "jan": case "feb" :
			System.out.println("Winter");
			break;
		case "mar" : case "apr" : case  "may": case "jun" :
			System.out.println("Summer");
			break;
		case "jul" : case "aug" : case  "sept": case "oct" :
			System.out.println("Monsoon");
			break;
			
		}
	}

}
