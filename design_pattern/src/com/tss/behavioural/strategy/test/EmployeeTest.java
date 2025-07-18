package com.tss.behavioural.strategy.test;

import com.tss.behavioural.strategy.model.Consultant;
import com.tss.behavioural.strategy.model.Employee;
import com.tss.behavioural.strategy.model.SeniorConsultant;
import com.tss.behavioural.strategy.model.TechLead;

public class EmployeeTest {
	
	public static void main(String[] args) {
		
		Employee emp = new Employee(1, "Hemanshi", new Consultant());
		
		    System.out.println(emp.getDescription());
		    System.out.println("Responsibility: " + emp.getResponsibility());

		 
		    emp.promote(new SeniorConsultant());
		    System.out.println("\nAfter Promotion:");
		    System.out.println(emp.getDescription());
		    System.out.println("Responsibility: " + emp.getResponsibility());

		   
		    emp.promote(new TechLead());
		    System.out.println("\nAfter Second Promotion:");
		    System.out.println(emp.getDescription());
		    System.out.println("Responsibility: " + emp.getResponsibility());
		}

}
