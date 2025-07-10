package com.tss.test;

import com.tss.model.Box;

public class BoxTest {

	public static void main(String[] args) {

		Box box1 = new Box();
		box1.initialize();
//		box1.display();
		
		System.out.println("the heigth of box1 is :" + box1.getHeight());
	
	}

}
