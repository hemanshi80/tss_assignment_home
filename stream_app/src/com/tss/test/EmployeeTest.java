package com.tss.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tss.model.Employee;

public class EmployeeTest {
	
	 public static void main(String[] args) {
	        List<Employee> employees = Arrays.asList(
	            new Employee(1, "Hemanshi", 50000, "HR"),
	            new Employee(2, "Deep", 60000, "IT"),
	            new Employee(3, "Dharmi", 60000, "IT"),
	            new Employee(4, "Harsh", 70000, "HR"),
	            new Employee(5, "Anup", 55000, "Sales"),
	            new Employee(6, "Mahek", 70000, "Sales")
	        );
	        
	        List<Employee> sortedEmployees = employees.stream()
	                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()
	                    .thenComparing(Employee::getName))
	                .collect(Collectors.toList());

	            System.out.println("Sorted Employees:");
	            sortedEmployees.forEach(System.out::println);
	            
	            Map<String, Employee> highestPaidByDept = employees.stream()
	                    .collect(Collectors.groupingBy(
	                        Employee::getDepartment,
	                        Collectors.collectingAndThen(
	                            Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
	                            Optional::get
	                        )
	                    ));

	                System.out.println("\nHighest Paid Employee by Department:");
	                highestPaidByDept.forEach((dept, emp) ->
	                    System.out.println(dept + ": " + emp));
}
}