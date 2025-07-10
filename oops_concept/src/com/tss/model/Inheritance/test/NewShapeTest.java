package com.tss.model.Inheritance.test;

import com.tss.model.Inheritance.model.NewCircle;
import com.tss.model.Inheritance.model.NewSquare;

public class NewShapeTest {

	public static void main(String[] args) {
		
		NewCircle circle = new NewCircle(10);
		circle.area();

		NewSquare square = new NewSquare(20);
		square.area();
	}

}
