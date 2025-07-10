package com.tss.model;

public class Demo {
	
	private int a;
	private int b;
	private int c;
	
	public Demo() {
		a =0;
		b = 0;
		c= 0;
	}
	
	public void Increment() {
		a++;
		b++;
		c++;
	}
	
	public void display() {
		System.out.println("a "+a);
		System.out.println("b "+b);
		System.out.println("c "+c);
	}
	
	static {
		System.out.println("in demo model");
	}

}
