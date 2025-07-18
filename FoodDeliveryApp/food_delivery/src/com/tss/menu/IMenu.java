package com.tss.menu;

import java.util.List;

import com.tss.model.FoodItem;

public interface IMenu {

	  List<FoodItem> getItems();
	  
	    String getCuisineName();
    
}
