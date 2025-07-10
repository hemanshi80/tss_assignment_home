package com.tss.model;

public class Student {

	private int rollNumber ;
	private String name;
	private int age;
	private int subject1 , subject2 , subject3;
	
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setSubjectMarks(int subject1 , int subject2 , int subject3) {
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
	}
	
	
	
	
	public int getRollNumber() {
		return rollNumber;
	}
	
	public String  getName() {
		return  name;
	}
	
	public int getAge() {
		return age ;
	}
	
	public int getSubject1Mark() {
		return subject1;
	}
	
	public int getSubject2Mark() {
		return subject2;
	}
	
	public int getSubject3Mark() {
		return subject3;
	}
	
	public float averageOfMarks(int subject1,int subject2,int subject3) {
		float average = (subject1 + subject2 + subject3) /3;
		return average;
	}
	
	public void display()
	{
		System.out.println("Name :"+ name);
		System.out.println("Age :"+ age);
		System.out.println("Roll no :"+ rollNumber);
		System.out.println("Subject1 :"+ subject1);
		System.out.println("Subject2 :"+ subject2);
		System.out.println("Subject3 :"+ subject3);

	}
	

}
