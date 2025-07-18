package com.tss.customer;

import java.util.List;

import com.tss.admin.DeliveryAgentManager;
import com.tss.delivery.IDeliveryAgent;
import com.tss.model.IDiscount;
import com.tss.orders.Order;
import com.tss.payment.IPayment;

public class CustomerPayment {
	
	private static final DeliveryAgentManager agentManager = new DeliveryAgentManager();
	
	  public static Order checkout(List<CartEntry> cartEntries, IDiscount discount, IPayment payment) {
	        double total = 0;
	        for (CartEntry entry : cartEntries) {
	            total += entry.getTotalPrice();
	        }

	        if (discount != null) {
	            total = discount.applyDiscount(total);
	        }

	        boolean paid = payment.pay(total);
	        if (!paid) {
	            System.out.println("Payment failed.");
	            return null;
	        }

	        IDeliveryAgent agent = agentManager.getRandomAgent();
	        if (agent == null) {
	            System.out.println("No delivery agents available.");
	            return null;
	        }

	        return new Order(cartEntries, total, payment, discount, agent);
	    }


}
