package com.tss.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.tss.model.Employee;
import com.tss.model.NameComparator;

public class EmployeeTest {

	public static void main(String[] args) {
		
		
		 List<Employee> employees = new ArrayList<>();
	        Scanner scanner = new Scanner(System.in);
	 

	        while (true) {
	           
	            System.out.println("1. Add Employee");
	            System.out.println("2. Display All Employees");
	            System.out.println("3. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            
	            switch (choice) {
	                case 1:
	                	readEmployee(scanner);
	                    System.out.println("Employee added successfully!");
	                    break;

	                case 2:
	                    {
	                        printEmployee(employees);
	                    }
	                    break;

	                case 3:
	                    System.out.println("Exiting program...");
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }

	        Collections.sort(employees , new NameComparator());
	       
	    }

	   
	    public static Employee readEmployee(Scanner scanner) {
	        Employee emp = new Employee(0, "", 0); 
	        System.out.print("Enter Employee Id: ");
	        emp.setEmployeeid(scanner.nextInt());
	        scanner.nextLine();

	        System.out.print("Enter Employee Name: ");
	        emp.setEmployeeName(scanner.nextLine());

	        System.out.print("Enter Employee Salary: ");
	        emp.setSalary(scanner.nextInt());
	        scanner.nextLine();

	        return emp;
	    }

	  
	    public static void printEmployee(List<Employee> employees) {
	        for (Employee emp : employees) {
	            System.out.println("Employee ID   : " + emp.getEmployeeid());
	            System.out.println("Employee Name : " + emp.getEmployeeName());
	            System.out.println("Salary        : " + emp.getSalary());
	            
	        }
		
	}
	
	
	

}
