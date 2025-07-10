package com.tss.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.tss.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Employee employee = new Employee();
		displayEmployeeInfo(employee, scanner);
	}

	public static void displayEmployeeInfo(Employee emp , Scanner scanner ) {
		
		System.out.println("Employee Name :");
		String name = scanner.nextLine();
		emp.setName(name);
		
		System.out.println("Employee Id :");
		int empid = scanner.nextInt();
		emp.setEmpId(empid);
		
		scanner.nextLine();
		
		boolean validDate = false;
	    String dateInput;

	    while (!validDate) {
	        System.out.print("Employee's Joining Date (dd-MM-yyyy): ");
	        dateInput = scanner.nextLine();
	        try {
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	            LocalDate.parse(dateInput, formatter);
	            emp.setJoiningDate(dateInput);
	            validDate = true;
	        } catch (Exception e) {
	            System.out.println("Invalid  format enter in dd-MM-yyyy format.");
	        }
	    }


		
		System.out.println("Employee's Salary :");
		int salary = scanner.nextInt();
		emp.setSalary(salary);
		
		emp.displayInfo();
		
		
	}
}
