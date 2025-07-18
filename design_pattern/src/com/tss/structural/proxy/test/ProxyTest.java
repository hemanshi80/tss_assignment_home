package com.tss.structural.proxy.test;

import com.tss.structural.proxy.model.IInternet;
import com.tss.structural.proxy.model.ProxyInternet;

public class ProxyTest {
    public static void main(String[] args) {
        IInternet internet = new ProxyInternet();
        try {
            internet.connectTo("example.com");
            internet.connectTo("abc.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}