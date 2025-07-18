package com.tss.model;

public class Employee {
	
	int id;
	  String name;
	    String department;
	    int salary;
	    
	    
		public Employee(int id, String name, int salary, String department) {
			super();
			this.id = id;
			this.name = name;
			this.department = department;
			this.salary = salary;
		}


		public int getId() {
			return id;
		}


		public String getName() {
			return name;
		}


		public String getDepartment() {
			return department;
		}


		public int getSalary() {
			return salary;
		}
	    
		@Override
		public String toString() {
		    return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + ", dept='" + department + "'}";
		}
	    
	    

}
