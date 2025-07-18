package com.tss.payment;

import java.io.Serializable;

public interface IPayment extends Serializable {
	
    boolean pay(double amount);
    String getPaymentMode();
}
