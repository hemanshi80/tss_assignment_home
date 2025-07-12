package com.tss.structural.adapter.model;

import java.util.List;

public class ShoppingCart {
	
	private List<IItems> cartItems;
	public ShoppingCart(List<IItems> cartItems) {
        this.cartItems = cartItems;
    }

    public void addItemsToCart(List<IItems> items) {
        cartItems.addAll(items);
    }

    public List<IItems> getCartItems() {
        return cartItems;
    }

    public double getCartPrice() {
        double total = 0;
        for (IItems item : cartItems) {
            total += item.getItemPrice();
        }
        return total;
    }

    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\nItem Name\tPrice");
        for (IItems item : cartItems) {
            System.out.printf("%-15s %.2f\n", item.getItemName(), item.getItemPrice());
        }

        System.out.println("------------------------");
        System.out.printf("Total\t\t%.2f\n", getCartPrice());
    }
	
	

}
