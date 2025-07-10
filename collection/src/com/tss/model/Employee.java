package com.tss.model;

public class Employee {

	private int employeeid;
	private String employeeName;
	private int salary;
	
	public Employee(int employeeid, String employeeName, int salary) {
		super();
		this.employeeid = employeeid;
		this.employeeName = employeeName;
		this.salary = salary;
	}
	

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeeName=" + employeeName + ", salary=" + salary + "]";
	}
	
	
}
