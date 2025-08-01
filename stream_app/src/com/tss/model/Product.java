package com.tss.model;

public class Product {

	 private String name;
	    private double price;
	    private int quantity;
	    
	    
		public Product(String name, double price, int quantity) {
			super();
			this.name = name;
			this.price = price;
			this.quantity = quantity;
		}


		public String getName() {
			return name;
		}


		public double getPrice() {
			return price;
		}


		public int getQuantity() {
			return quantity;
		}


		@Override
		public String toString() {
			return "Product [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
		}
		
		
	    
}
