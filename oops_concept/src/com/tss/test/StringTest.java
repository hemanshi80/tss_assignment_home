package com.tss.test;

public class StringTest {

	public static void main(String[] args) {
		
		StringBuilder string3 = new StringBuilder ("deep");
		StringBuilder string2 = new StringBuilder ("hemanshi");

		System.out.println(string3.hashCode());
		System.out.println(string2.hashCode());
		
		string3 = string2;
		
		System.out.println(string3.hashCode());;
		System.out.println(string2.hashCode());
		
		System.out.println(string3==string2);
		
		System.out.println(string3.hashCode());
		System.out.println(string2.hashCode());
		
	}

}
