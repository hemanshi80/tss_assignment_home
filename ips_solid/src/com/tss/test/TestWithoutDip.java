package com.tss.test;

import com.tss.model.CreditCard2;
import com.tss.model.IPayment;
import com.tss.model.ShoppingCart2;
import com.tss.model.UPIPayment;

public class TestWithoutDip {

	public static void main(String[] args) {
        IPayment payment = new CreditCard2(); 
        ShoppingCart2 cart = new ShoppingCart2(payment);
        cart.checkout(500);
        
        IPayment UPIPayment = new UPIPayment();
        ShoppingCart2 cart2 = new ShoppingCart2(UPIPayment);
        cart2.checkout(300);
    }
}
