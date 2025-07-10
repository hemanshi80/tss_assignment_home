package com.tss.model.Inheritance.test;
import com.tss.model.Inheritance.model.Shape;
import com.tss.model.Inheritance.model.Circle;
import com.tss.model.Inheritance.model.Square;

public class ShapeTest {

	public static void main(String[] args) {
		
		Shape circle = new Circle(10);
		circle.area();

		Shape square = new Square(20);
		square.area();
		
		
	}

}
