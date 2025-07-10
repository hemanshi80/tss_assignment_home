package com.tss.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.tss.model.Customer;

public class CustomerTest {

	public static void main(String[] args) {
		
		Supplier<List<Customer>> customerSupplier = () -> {
            List<Customer> customers = new ArrayList<>();
            customers.add(new Customer("Hemanshi", 30, 40000, 1300));
            customers.add(new Customer("Dharmi", 28, 50000, 1300));
            customers.add(new Customer("Diya", 20, 20000, 600));  
            customers.add(new Customer("Fenisha", 23, 22000, 700)); 
            return customers;
        };
        
        Predicate<Customer> isEligible = c ->
        c.getAge() >= 21 &&
        c.getIncome() >= 25000 &&
        c.getCreditScore() >= 650;
        
        Function<Customer, Double> calculateLoanAmount = c ->
        c.getIncome() * (c.getCreditScore() / 1000.0);

        Consumer<Customer> approveLoan = c -> {
            double amount = calculateLoanAmount.apply(c);
            System.out.println("Loan Approved for " + c.getName());
            System.out.println("Loan Amount: ₹" + amount);
        };
        
        for (Customer c : customerSupplier.get()) {
            if (isEligible.test(c)) {
                approveLoan.accept(c);
            }
        }
	}

}
