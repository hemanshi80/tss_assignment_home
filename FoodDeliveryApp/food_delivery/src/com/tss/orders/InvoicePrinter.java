package com.tss.orders;

import com.tss.customer.CartEntry;
import com.tss.model.FoodItem;

public class InvoicePrinter {

	public static void printInvoice(Order order) {
        System.out.println("\n========= INVOICE =========");

        double total = 0;
        for (CartEntry entry : order.getCartEntries()) {
        	String itemName = entry.getItem().getName();
            int quantity = entry.getQuantity();
            double price = entry.getItem().getPrice();
            double entryTotal = entry.getTotalPrice();
            
            System.out.printf("%-20s x%-3d = ₹%.2f\n", itemName, quantity, entryTotal);
            total += entryTotal;
        }

        System.out.println("----------------------------");
        System.out.println("Subtotal: ₹" + total);

        double discountedTotal = total;
        if (order.getDiscount() != null) {
            discountedTotal = order.getDiscount().applyDiscount(total);
        }

        System.out.println("Total after Discount: ₹" + discountedTotal);
        System.out.println("Payment Method: " + order.getPayment().getPaymentMode());
        System.out.println("Delivery By: " + order.getDeliveryAgent().getName());

        System.out.println("============================\n");
    }
}
