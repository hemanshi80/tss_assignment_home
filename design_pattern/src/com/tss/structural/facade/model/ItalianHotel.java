package com.tss.structural.facade.model;

public class ItalianHotel implements IHotel{

	public IMenu getMenu() {
		
		return new ItalianMenu();
	}

}
