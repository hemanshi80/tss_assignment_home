package com.tss.test;

public class WrapperClass {

	public static void main(String[] args) {
		
		int a = 10;
		System.out.println(a);
		
		Integer b =12;
		System.out.println(b);
		
		a=b; //autoboxing
		System.out.println(a);
		
		Integer num = new Integer(15); //deprecated syntax
		
		System.out.println(num);
		
		int c = b.intValue(); //unboxing
		System.out.println(c);
		
		Integer d = 20;
		c=d; //auto-unboxing
		System.out.println(c);
		
		String str = "123";
		int test = Integer.parseInt(str);
		System.out.println(test);
	}

}
