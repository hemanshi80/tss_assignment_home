package com.tss.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	private Calculator calculator;
	
	@BeforeEach
	void init() {
		calculator = new Calculator();
	}
	
	@AfterAll
	static void display() {
		System.out.println("Testing Done");
	}

	@Test
	void testAddititon() {
		int actualResult = calculator.addition(5, 8);
		
		assertEquals(13, actualResult);
	}

	@Test
	void testSubtraction() {
		int actualResult = calculator.subtraction(8,5);
		
		assertEquals(3, actualResult);
		
	}
	
	@Test
	void testMultiplication() {
		int actualResult = calculator.multiplication(5,5);
		
		assertEquals(25, actualResult);
		
		
	}
	
	@Test
	void testDivision() {
		
		int actualResult = calculator.division(10,0);
		assertEquals(2, actualResult);
		assertThrows(ArithmeticException.class, () -> calculator.division(2,0));
		
	}

}
