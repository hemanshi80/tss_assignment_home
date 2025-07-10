package com.tss.model.Inheritance.model;

public class Box {
	private int width;
	private int depth;
	private int height;
	
	public Box (int width , int depth , int height)
	{
		System.out.println("Width ="+width);
		System.out.println("Depth ="+depth);
		System.out.println("Height ="+height);
	}
	
	public void display()
	{
		System.out.println("Width ="+width);
		System.out.println("Depth ="+depth);
		System.out.println("Height ="+height);

	}

}
