package com.tss.delivery;

public class DeliveryAgent implements IDeliveryAgent {

    private static final long serialVersionUID = 1L;
    private final String name;

    public DeliveryAgent(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void deliver(String customerName, String address) {
        System.out.println(name + " delivering to " + customerName + " at " + address);
    }
}
