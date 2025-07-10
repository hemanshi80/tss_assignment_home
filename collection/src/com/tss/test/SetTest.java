package com.tss.test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {

		Set<Integer> set = new LinkedHashSet<>();
		
		set.add(10);
		set.add(20);
		set.add(40);
		set.add(30);
		set.add(60);
		

		
		System.out.println(set);
		
	}

}
