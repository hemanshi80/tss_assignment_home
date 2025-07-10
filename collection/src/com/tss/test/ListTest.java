package com.tss.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListTest {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();

		names.add("Hemanshi");
		names.add("Dharmi");
		names.add("Diya");
		names.add("Fenisha");
		
		System.out.println(names);

		names.remove(3);
		

		System.out.println(names);

		names.add(2, "Deep");
		System.out.println(names);

		names.set(1, "Harsh");
		System.out.println(names);

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		System.out.println();
		for (String object : names) {
			System.out.println(object);
		}

		Iterator<String> iterator = names.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next());
		}
		System.out.println();

		ListIterator<String> listIterator = names.listIterator();
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		System.out.println();
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}
		
		

	}

}
