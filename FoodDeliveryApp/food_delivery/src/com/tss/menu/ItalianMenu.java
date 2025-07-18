package com.tss.menu;

import java.util.Arrays;
import java.util.List;

import com.tss.model.FoodItem;

public class ItalianMenu implements IMenu {

    @Override
    public List<FoodItem> getItems() {
        return Arrays.asList(
            new FoodItem("Pasta", 180),
            new FoodItem("Pizza", 250),
            new FoodItem("Lasagna", 300)
        );
    }

    @Override
    public String getCuisineName() {
        return "Italian";
    }
}
