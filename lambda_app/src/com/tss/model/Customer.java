package com.tss.model;

public class Customer {
	
	 private String name;
	 private int age;
	 private double income;
	 private int creditScore;
	 
	 
	 public Customer(String name, int age, double income, int creditScore) {
		super();
		this.name = name;
		this.age = age;
		this.income = income;
		this.creditScore = creditScore;
	 }


	 public String getName() {
		 return name;
	 }


	 public int getAge() {
		 return age;
	 }


	 public double getIncome() {
		 return income;
	 }


	 public int getCreditScore() {
		 return creditScore;
	 }

	 
}
