package com.tss.model;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Employee {
	private int empid ,salary;
	private String name, joiningDate;
	LocalDate currentDate = LocalDate.now();
	
	
	public Employee() {
		empid = 0;
		salary =0;
		name = "";
		joiningDate = "";
		
	}
	
	public Employee(int empid, int salary, String name,String joiningDate) {
		this.empid = 0;
		this.salary = 0;
		this.name = "";
		this.joiningDate = "";
	}
	
	
	public void setEmpId(int empid) {
		this.empid = empid;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	
	public int getEmpId() {
		return empid;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public String getName() {
		return name;
	}
	
	public String getJoiningDate() {
		return joiningDate;
	}
	
	
	public void empExperience() {
	try{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate empJoiningDate = LocalDate.parse(joiningDate,formatter) ;
		Period experience = Period.between(empJoiningDate , currentDate);
		System.out.println("The experience of employee is :" +experience.getYears());
		}
	catch(Exception e){
		System.out.println("Invalid Date");
		
	}
		
	}
	
	public void calcBonus () {
		salary = (int)(salary + (salary * (0.5)));
		System.out.println("Employee's Bonus :" + salary);
	}
	
	public void displayInfo() {
		System.out.println("Employee Name :" + name);
		System.out.println("Employee Id :" + empid );
		System.out.println("Employee' joining date :" + joiningDate);
		empExperience();
		System.out.println("Employee Salary :" + salary);
		calcBonus();
		
	}
	
	
	
	
	



	
}
