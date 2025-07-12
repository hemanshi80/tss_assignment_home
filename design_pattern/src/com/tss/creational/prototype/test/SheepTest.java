package com.tss.creational.prototype.test;

import com.tss.creational.prototype.model.Sheep;

public class SheepTest {

	public static void main(String[] args) {
		
		Sheep originalSheep = new Sheep("Dolly");
		Sheep clonedSheep = originalSheep.clone();
		clonedSheep.setName("Dolly Clone");

		System.out.println(originalSheep);
		System.out.println(clonedSheep);

	}

}
