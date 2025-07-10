package com.tss.model.Inheritance.model;

public interface IDemo {

	public static void method1() {
		System.out.println("STATIC METHOD");
	}
	
	public default void mehtod2() {
		method3();
		System.out.println("Defaulttt");
	}
	
	private void method3()
	{
		System.out.println("Privateeee");
	}
}

