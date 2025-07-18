package com.tss.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Question5 {
	public static void main(String[] args) {
		
		List<String> sentences = Arrays.asList("Hemanshi", "Deep", "Hemanshi");

//        List<String> uniqueWords = sentences.stream()
//            .flatMap(sentence -> Arrays.stream(sentence.toLowerCase().split("\\s+")))
//            .distinct()
//            .sorted()
//            .collect(Collectors.toList());
		
		Set<String> uniqueWords = sentences.stream()
	            .flatMap(sentence -> Arrays.stream(sentence.toLowerCase().split("\\s+")))
	            .collect(Collectors.toCollection(HashSet::new)); 

        System.out.println("Unique sorted words: " + uniqueWords);
	}
}
