package com.tss.model;

public class Box {
	
	private int width;
	private int depth;
	private int height;
	
	public void setWidth(int width) {
		this.width = width;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
	
	public int getHeight() {
		return height;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public int getWidth() {
		return width;
	}
	
	
	
	public void initialize()
	{
		width = 0;
		depth =0;
		height =10;
	}
	
	public void display()
	{
		System.out.println("Width ="+width);
		System.out.println("Depth ="+depth);
		System.out.println("Height ="+height);

	}
}
