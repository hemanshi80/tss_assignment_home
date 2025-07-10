package com.tss.basics.commandline;



public class AreaOfCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		float radius = Float.parseFloat(args[0]);
		
		areaOfCircle(radius);
		
	}

	private static void areaOfCircle(float radius)
	{
		double area = 3.14 * radius * radius;
		
		System.out.println("Area of Circle : " + area);
		
	}
	
}
