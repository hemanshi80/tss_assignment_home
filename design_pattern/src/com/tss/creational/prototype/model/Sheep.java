package com.tss.creational.prototype.model;

public class Sheep implements Cloneable {
	
	private String name;

	public Sheep(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sheep clone() {
		try {
			return (Sheep) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	@Override
	public String toString() {
		return "Sheep [name=" + name + "]";
	}

}
