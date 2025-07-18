package com.tss.orders;

import java.io.Serializable;
import java.util.List;

import com.tss.customer.CartEntry;
import com.tss.delivery.IDeliveryAgent;
import com.tss.model.IDiscount;
import com.tss.payment.IPayment;

public class Order  implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<CartEntry> cartEntries;
    private double totalAmount;
    private IPayment payment;
    private IDiscount discount;
    private IDeliveryAgent deliveryAgent;

    public Order(List<CartEntry> cartEntries, double totalAmount, IPayment payment, IDiscount discount, IDeliveryAgent deliveryAgent) {
    	this.cartEntries = cartEntries;
        this.totalAmount = totalAmount;
        this.payment = payment;
        this.discount = discount;
        this.deliveryAgent = deliveryAgent;
    }

    public List<CartEntry> getCartEntries() {
        return cartEntries;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public IPayment getPayment() {
        return payment;
    }

    public IDiscount getDiscount() {
        return discount;
    }

    public IDeliveryAgent getDeliveryAgent() {
        return deliveryAgent;
    }
}