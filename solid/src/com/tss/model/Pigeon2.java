package com.tss.model;

public class Pigeon2 implements IBird, IFlyable, IWalkable {
    public void fly() {
        System.out.println("Pigeon flies");
    }

    public void walk() {
        System.out.println("Pigeon walks");
    }

    public void getcolor() {
        System.out.println("Color: Grey");
    }
}