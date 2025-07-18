package com.tss.test;

import java.util.Arrays;
import java.util.List;

import com.tss.model.Product;

public class ProductTest {

	public static void main(String[] args) {
		
		  List<Product> products = Arrays.asList(
		            new Product("Kurkure", 10.0, 2),
		            new Product("Dairy Milk", 50.0, 1),
		            new Product("Pop-rings", 5.0, 3)
		        );

		        double total = products.stream()
		            .mapToDouble(p -> p.getPrice() * p.getQuantity())
		            .reduce(0.0, Double::sum);

		        System.out.println("Total bill: " + total);

	}

}
