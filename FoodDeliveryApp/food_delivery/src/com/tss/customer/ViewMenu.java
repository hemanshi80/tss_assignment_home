package com.tss.customer;

import java.util.List;

import com.tss.model.FoodItem;

public class ViewMenu {


    public static void displayMenu(List<FoodItem> menuItems) {
        if (menuItems == null || menuItems.isEmpty()) {
            System.out.println("Menu is currently unavailable.");
            return;
        }
        
        System.out.println("----- Available Food Items -----");
        int index = 1;
        for (FoodItem item : menuItems) {
            System.out.printf("%d. %-25s ₹%.2f%n", index++, item.getName(), item.getPrice());
        }
    }
}
