package com.tss.test;

import com.tss.model.Bird;
import com.tss.model.Ostrich;
import com.tss.model.Pigeon;
import com.tss.model.Sparrow;

public class BirdTest {

	public static void main(String[] args) {
		

		 Bird bird1 = new Sparrow();
	     Bird bird2 = new Pigeon();
	     Bird bird3 = new Ostrich(); 

	     bird1.fly(); 
	     bird2.fly(); 
	     bird3.fly(); 
		 

	}

}
