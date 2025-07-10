package com.tss.test;

import com.tss.model.Demo;

public class DemoTest {

	public static void main(String[] args) {
		
		Demo demo1 = new Demo();
		Demo demo2 = new Demo();
		Demo demo3 = new Demo();
		
		demo1.Increment();
		demo1.display();
		
		demo2.Increment();
		demo2.display();
		
		demo2.Increment();
		demo1.display();
		
		
		
	}
	static {
	System.out.println("staiccc");	
	}
	

}
