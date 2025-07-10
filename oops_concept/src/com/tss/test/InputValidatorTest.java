package com.tss.test;

import java.util.Scanner;

import com.tss.model.InputValidator;

public class InputValidatorTest {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        
		 while(true) {
		 	System.out.print("Enter username: ");
	        String username = sc.nextLine();
	        if (InputValidator.validateUsername(username)) {
		        System.out.println("Username Is Valid");
	        	break;
	        } 
        	System.out.println("Invalid username. It must be 3-20 characters long and not empty.");

	        }

	        
	        while(true) {
	        System.out.print("Enter password (8-30) characters: ");
	        String password = sc.nextLine();
	        if (InputValidator.validatePassword(password)) {
	            System.out.println("Password is valid.");
	        	break;
	        }
        	System.out.println("Invalid password. It must be 8-30 characters long and not empty.");

	        }

	        while(true) {
	        System.out.print("Enter email: ");
	        String email = sc.nextLine();
	        if (InputValidator.validateEmail(email)) {
		        System.out.println("Email is valid.");
	            break;
	        }
            System.out.println("Invalid email. It must be 5-50 characters long and contain '@' and '.'");

	    }
	}
}
