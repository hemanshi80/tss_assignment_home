package com.tss.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.tss.model.Account;

public class AccountTest {

	public static void main(String[] args) {
	
		List<Account> accounts = Arrays.asList(
                new Account(1, "Deep", 35000),
                new Account(2, "Mahek", 45000),
                new Account(3, "Rishit", 55000),
                new Account(4, "Harshad", 25000),
                new Account(5, "Priyank", 30000)
        );

		accounts.stream()
		.min(Comparator.comparingDouble(Account::getSalary))
		.ifPresent(account -> System.out.println("Minimum Balance :"+ account));
		
		accounts.stream()
        .max(Comparator.comparingDouble(Account::getSalary))
        .ifPresent(account -> System.out.println("Max Balance: " + account));
		
		accounts.stream()
        .filter(account -> account.getName().length() > 6)
        .forEach(account -> System.out.println("Long Name: " + account.getName()));
		
		double total = accounts.stream()
                .mapToDouble(Account::getSalary)
                .sum();
        System.out.println("Total Balance: " + total);
		
		
	}

}
