package com.tss.test;

import com.tss.model.Demo;
import com.tss.model.IDemo2;

public class Test {

	public static void main(String[] args) {
		IDemo2 demo = Demo :: display;
		show(demo);
		Demo d1 = new Demo();

		IDemo2 demo1 = d1 :: show  ;
		show(demo1);
		
	}
	private static void show(IDemo2 demo)
	{
		demo.accept();

	}

}
