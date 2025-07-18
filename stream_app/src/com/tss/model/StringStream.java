package com.tss.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringStream {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Jay" , "Mahesh" , "Mark ", "Nimesh" , "Ramesh");
		
		 names.stream().sorted()
		 .limit(3)
		 .forEach(name -> System.out.println("Name: " + name));
		 
		 names.stream().filter(name -> name.toLowerCase().contains("a"))
         .sorted()
         .limit(3)
         .forEach(name -> System.out.println("Name with 'a': " + name));
		
		 names.stream()
         .sorted(Comparator.reverseOrder())
         .forEach(name -> System.out.println("Descending order: " + name));
		 
		 names.stream()
         .map(name -> name.length() >= 3 ? name.substring(0, 3) : name)
         .forEach(part -> System.out.println("First 3 character : " + part));
		 
		 names.stream()
         .map(String::trim)
         .filter(name -> name.length() <= 4)
         .forEach(name -> System.out.println("less than equal to 4 character name : " + name));
		 

	}

}
