package com.tss.test;

import com.tss.model.IDemo;

public class DemoTest {
	
	public static void main (String []args) {
		
		IDemo obj = ()-> System.out.println("Learning functional interface");
		
		obj.display();
	}

}
