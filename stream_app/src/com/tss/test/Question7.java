package com.tss.test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Question7 {
	public static void main(String[] args) {
		
		   List<String> allEmails = Arrays.asList("hemanshi@gmail.com", "hemanshi@yahoo.com", "hemanshi@tssconsultancy.com");

	        Set<String> emailDomains = allEmails.stream()
	            .map(email -> email.substring(email.indexOf("@") + 1))
	            .collect(Collectors.toSet());

	        System.out.println("Unique domains: " + emailDomains);
	}
}
