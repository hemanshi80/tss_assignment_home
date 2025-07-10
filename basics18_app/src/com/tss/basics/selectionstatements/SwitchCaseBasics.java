package com.tss.basics.selectionstatements;

import java.util.Random;

public class SwitchCaseBasics {

	public static void main(String[] args) {
		
		Random random = new Random();
		int random_number = random.nextInt(7);
		
		System.out.println("Number Generated :" + random_number);
		
		switch(random_number) {
		
		case 1: System.out.println("Monday");
				break;
		case 2: System.out.println("Tuesday");
		break;
		case 3: System.out.println("Wednesday");
		break;
		case 4: System.out.println("Thrusday");
		break;
		case 5: System.out.println("Friday");
		break;
		case 6: System.out.println("Saturday");
		break;
		case 7: System.out.println("Sunday");
		break;
		
		default : System.out.println("....");
		break;
		}
		
	}

}
