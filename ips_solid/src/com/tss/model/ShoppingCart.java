package com.tss.model;

public class ShoppingCart {

	  private CreditCard creditCard;

	    public ShoppingCart() {
	        
	        this.creditCard = new CreditCard();
	    }

	    public void checkout(int amount) {
	        creditCard.pay(amount);  
	    }
}
