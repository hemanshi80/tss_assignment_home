package com.tss.test;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class AdditionTest {
	
	public static void main (String []args) {
	
//		BiConsumer<Integer, Integer> addition = (a, b) -> {
//            int sum = a + b;
//            System.out.println("Addition of " + a + " + " + b + " : " + sum);
//        };
//
//        addition.accept(1, 3);  
		
		
		BiFunction<Integer, Integer, Integer> addition = (a, b) -> a + b;

        int result = addition.apply(1, 3);
        System.out.println("Addition of 1 + 3 : " + result);
}
}
