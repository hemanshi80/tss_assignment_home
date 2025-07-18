 package com.tss.behavioural.strategy.model;

public class Employee {
	
	private int id;
	private String name;
	private IRole role;
	
	public Employee(int id, String name, IRole role) {
	    this.id = id;
	    this.name = name;
	    this.role = role;
	}

	public void promote(IRole newRole) {
	    this.role = newRole;
	}

	public String getDescription() {
	    return "Employee [id=" + id + ", name=" + name + ", role=" + role.description() + "]";
	}

	public String getRoleDescription() {
	    return role.description();
	}

	public String getResponsibility() {
	    return role.responsibility();
	}

}
