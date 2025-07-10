package com.tss.model.Inheritance.model;

public class BoxWeight extends Box{
	
	private int weight;
	
	public BoxWeight(int weight, int height , int width , int depth) {
		super(height , width , depth);
		this.weight = weight;
			
	}
	
	public void displayBox() {
		System.out.println("Weight :" +this.weight);
			
	}

}
