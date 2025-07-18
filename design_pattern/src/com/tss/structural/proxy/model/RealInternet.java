package com.tss.structural.proxy.model;

public class RealInternet implements IInternet {
    @Override
    public void connectTo(String serverHost) throws Exception {
        System.out.println("Connecting to " + serverHost);
    }
}