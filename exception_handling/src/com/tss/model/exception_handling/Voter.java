package com.tss.model.exception_handling;

import com.tss.exception.AgeNotValidException;

public class Voter {

	private String name;
	private int voterId,age;
	
	public Voter(String name, int voterId, int age) {
		super();
		this.name = name;
		this.voterId = voterId;
		if(age<18)
			throw new AgeNotValidException(age);
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVoterId() {
		return voterId;
	}

	public void setVoterId(int voterId) {
		this.voterId = voterId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age<18)
			throw new AgeNotValidException(age);
		this.age = age;
	}

	@Override
	public String toString() {
		return "Voter [name=" + name + ", voterId=" + voterId + ", age=" + age + "]";
	}
}
