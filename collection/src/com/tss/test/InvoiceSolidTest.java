package com.tss.test;

import java.util.ArrayList;
import java.util.Scanner;

import com.tss.model.Calculate;
import com.tss.model.InvoiceSolid;
import com.tss.model.Print;

public class InvoiceSolidTest {

	public static void main(String[] args) {
		   Scanner scanner = new Scanner(System.in);
	        ArrayList<InvoiceSolid> invoices = new ArrayList<>();
	        Calculate calculator = new Calculate();
	        Print printer = new Print();

	        System.out.print("How many invoices? ");
	        int n = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        for (int i = 0; i < n; i++) {
	            System.out.println("\nEnter details for invoice " + (i + 1) + ":");

	            System.out.print("ID: ");
	            int id = scanner.nextInt();
	            scanner.nextLine();

	            System.out.print("Description: ");
	            String description = scanner.nextLine();

	            System.out.print("Cost: ");
	            double cost = scanner.nextDouble();

	            System.out.print("Discount Percentage: ");
	            double discountPercent = scanner.nextDouble();

	            InvoiceSolid invoice = new InvoiceSolid(id, description, cost, discountPercent);
	            invoices.add(invoice);
	        }

	        System.out.println("\n========== Invoice Details ==========");
	        for (InvoiceSolid inv : invoices) {
	            printer.print(inv, calculator);
	            System.out.println();
	        }

	        scanner.close();
	    }
	}


