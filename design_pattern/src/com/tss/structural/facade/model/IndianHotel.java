package com.tss.structural.facade.model;

public class IndianHotel implements IHotel{

	public IMenu getMenu() {
		
		return new IndianMenu();
	}

}
