package com.tss.delivery;

import java.io.Serializable;

public interface IDeliveryAgent extends Serializable {
	
	String getName();
    void deliver(String customerName, String address);
}
