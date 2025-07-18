package com.tss.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AreaCalculatorTest {
	
	private AreaCalculator calculator;
	
	@BeforeEach
	void init() {
		calculator = new AreaCalculator();
	}
	
	@Test
	void testAreaOfCircle() {
		double actualResult =  calculator.areaOfCircle(10);
		assertEquals(314, actualResult);
	}
	
	@Test
	void testAreaOfRectangle() {
		double actualResult =  calculator.areaOfRectangle(10, 30);
		assertEquals(300, actualResult);
	}

}
