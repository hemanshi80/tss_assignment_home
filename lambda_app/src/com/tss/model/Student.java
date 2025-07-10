package com.tss.model;

public class Student {

	private String name;
	private int rollNo;
	private float marks;
	
	
	public Student(String name, int rollNo, float marks) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}


	public String getName() {
		return name;
	}


	public int getRollNo() {
		return rollNo;
	}


	public float getMarks() {
		return marks;
	}
	
	
}
