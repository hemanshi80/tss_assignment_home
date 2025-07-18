package com.tss.customer;

import java.util.List;
import java.util.Scanner;

public class CustomerLogin {
	  private static final Scanner scanner = new Scanner(System.in);

	    public static Customer authenticate(List<Customer> customerList) {
	        System.out.println("Are you a new customer? (yes/no): ");
	        String response = scanner.nextLine().trim().toLowerCase();

	        if (response.equals("yes")) {
	            Customer newCustomer = register(customerList);
	            if (newCustomer != null) {
	                customerList.add(newCustomer);
	                System.out.println("Registration successful. Please log in.");
	            }
	        }

	        return login(customerList);
	    }

	    public static Customer register(List<Customer> customerList) {
	        System.out.println("----- Customer Registration -----");
	        System.out.print("Enter full name: ");
	        String name = scanner.nextLine();

	        System.out.print("Enter phone number: ");
	        String phone = scanner.nextLine();

	        System.out.print("Enter address: ");
	        String address = scanner.nextLine();

	        System.out.print("Enter email: ");
	        String email = scanner.nextLine();

	        String username;
	        while (true) {
	            System.out.print("Choose a username: ");
	            username = scanner.nextLine();

	            boolean exists = false;
	            for (Customer c : customerList) {
	                if (c.getUsername().equalsIgnoreCase(username)) {
	                    System.out.println("Username already taken. Try another.");
	                    exists = true;
	                    break;
	                }
	            }
	            if (!exists) break;
	        }

	        System.out.print("Choose a password: ");
	        String password = scanner.nextLine();

	        return new Customer(name, phone, address, email, username, password);
	    }

	    public static Customer login(List<Customer> customerList) {
	        System.out.println("----- Customer Login -----");
	        System.out.print("Username: ");
	        String username = scanner.nextLine();

	        System.out.print("Password: ");
	        String password = scanner.nextLine();

	        for (Customer customer : customerList) {
	            if (customer.getUsername().equalsIgnoreCase(username) &&
	                customer.checkPassword(password)) {
	                System.out.println("Login successful. Welcome, " + customer.getName());
	                return customer;
	            }
	        }

	        System.out.println("Invalid credentials.");
	        return null;
	    }
}
