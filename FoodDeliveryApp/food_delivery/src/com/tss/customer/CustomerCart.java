package com.tss.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tss.model.FoodItem;

public class CustomerCart implements Serializable {

	 private static final long serialVersionUID = 1L;

	    private List<CartEntry> cartItems;

	    public CustomerCart() {
	        this.cartItems = new ArrayList<>();
	    }

	    public void addItem(FoodItem item, int quantity) {
	        boolean updated = false;
	        for (CartEntry entry : cartItems) {
	            if (entry.getItem().getName().equalsIgnoreCase(item.getName())) {
	                entry.increaseQuantity(quantity);
	                updated = true;
	                break;
	            }
	        }
	        if (!updated) {
	            cartItems.add(new CartEntry(item, quantity));
	        }
	        System.out.println(item.getName() + " x" + quantity + " added to cart.");
	    }

	    public void viewCart() {
	        if (cartItems.isEmpty()) {
	            System.out.println("Cart is empty.");
	            return;
	        }
	        System.out.println("Cart Items:");
	        double total = 0;
	        for (CartEntry entry : cartItems) {
	            System.out.println(entry.getItem().getName() + " x" + entry.getQuantity() + " = ₹" + entry.getTotalPrice());
	            total += entry.getTotalPrice();
	        }
	        System.out.println("Total: ₹" + total);
	    }

	    public List<FoodItem> getItems() {
	        List<FoodItem> flatList = new ArrayList<>();
	        for (CartEntry entry : cartItems) {
	            for (int i = 0; i < entry.getQuantity(); i++) {
	                flatList.add(entry.getItem());
	            }
	        }
	        return flatList;
	    }
	     
	    
	    public List<CartEntry> getCartEntries() {
	        return new ArrayList<>(cartItems);
	    }

	    public void clearCart() {
	        cartItems.clear();
	        System.out.println("Cart cleared.");
	    }

	    public boolean isEmpty() {
	        return cartItems.isEmpty();
	    }
	    
	    public void removeItem(int index) {
	        if (index >= 0 && index < cartItems.size()) {
	            CartEntry removed = cartItems.remove(index);
	            System.out.println("Removed: " + removed.getItem().getName() + " x" + removed.getQuantity());
	        } else {
	            System.out.println("Invalid item number.");
	        }
	    }
}