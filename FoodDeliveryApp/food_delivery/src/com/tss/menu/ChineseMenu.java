package com.tss.menu;

import java.util.Arrays;
import java.util.List;

import com.tss.model.FoodItem;

public class ChineseMenu implements IMenu {

    @Override
    public List<FoodItem> getItems() {
        return Arrays.asList(
            new FoodItem("Noodles", 120),
            new FoodItem("Manchurian", 150),
            new FoodItem("Spring Rolls", 100)
        );
    }

    @Override
    public String getCuisineName() {
        return "Chinese";
    }
}
