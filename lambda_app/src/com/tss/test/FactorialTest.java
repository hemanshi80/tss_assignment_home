package com.tss.test;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FactorialTest {

	public static void main(String[] args) {
		
		Supplier <Integer> randomNumberSupplier=()->{
			Random random = new Random();
			return random.nextInt(100);
		};
		
		Function<Integer , Integer> facto = (number)->{
			int facts = 1;
			for (int i=1 ; i<number; i++)
				facts=facts*1;
			return number;
		};
		
		System.out.println("Factorial :" + facto.apply(7));
		
		System.out.println("Random number : " +randomNumberSupplier.get());
//		
//		  Consumer<Integer> factorial = (n) -> {
//	            int fact = 1;
//	            for (int i = 1; i <= n; i++) {
//	                fact *= i;
//	            }
//	            System.out.println("Factorial of " + n + " : " + fact);
//	        };
//
//	        factorial.accept(7);
			
	}

}
