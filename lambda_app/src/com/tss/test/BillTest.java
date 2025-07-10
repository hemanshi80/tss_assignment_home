package com.tss.test;

import java.util.function.Function;
import java.util.function.Supplier;

import com.tss.model.Bill;

public class BillTest {

	public static void main(String[] args) {

		String itemName = "Shirt";
		double basePrice = 400;
		
		Supplier<Double> shippingSupplier = () -> 10.0;
		
		Function<Double , Bill> billfunc = price -> {
			
			double tax = price * 0.18;
			double shipping = shippingSupplier.get();
			double finalAmount = price + tax + shipping;
			return new Bill(itemName ,basePrice, tax, shipping, finalAmount);
		};
		
		Bill total = billfunc.apply(basePrice);
		System.out.println(total);
	}

}
