package com.tss.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question4 {

	public static void main(String[] args) {
		  List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry", "cherry");
		  
		  Map<Character , Long> letterCount = words.stream()
				  .collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.counting()));
		  
		  System.out.println("Word count by first letter: " + letterCount);
	}

}
