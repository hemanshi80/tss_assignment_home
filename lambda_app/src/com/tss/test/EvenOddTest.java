package com.tss.test;

import java.util.function.Predicate;

public class EvenOddTest {

	public static void main (String []args) {
		
		Predicate<Integer> isEven = (n) -> n%2 ==0;
		int num = 1;
		boolean answer = isEven.test(num);
		System.out.println(num +" is even ?" + answer);
	}
}
