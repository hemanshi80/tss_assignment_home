package com.tss.admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tss.model.FoodItem;

public class MenuManager  implements Serializable {

    private static final long serialVersionUID = 1L;
    private final List<FoodItem> menuItems;

    public MenuManager() {
        this.menuItems = new ArrayList<>();
    }

    public void addFoodItem(FoodItem item) {
        if (item != null) {
            menuItems.add(item);
        }
    }


    public void removeFoodItemByIndex(int index) {
        if (index < 1 || index > menuItems.size()) {
            System.out.println("Invalid item number.");
            return;
        }
        FoodItem removed = menuItems.remove(index - 1);
        System.out.println(removed.getName() + " removed from the menu.");
    }
    
    public List<FoodItem> getMenuItems() {
        return new ArrayList<>(menuItems); 
    }

    public void displayMenu() {
        if (menuItems.isEmpty()) {
            System.out.println("Menu is currently empty.");
            return;
        } 
        System.out.println("Menu Items:");
        int index = 1;
        for (FoodItem item : menuItems) {
            System.out.printf("%d. %-25s ₹%.2f\n", index++, item.getName(), item.getPrice());
        }
    }
}