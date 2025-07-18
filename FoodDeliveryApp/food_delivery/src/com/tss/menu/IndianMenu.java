package com.tss.menu;

import java.util.Arrays;
import java.util.List;

import com.tss.model.FoodItem;

public class IndianMenu  implements IMenu {

    @Override
    public List<FoodItem> getItems() {
        return Arrays.asList(
            new FoodItem("Paneer Butter Masala", 200),
            new FoodItem("Butter Naan", 40),
            new FoodItem("Biryani", 180)
        );
    }

    @Override
    public String getCuisineName() {
        return "Indian";
    }
}