package com.tss.model;

public class Labour implements IWorker {
	
	
    public void startWork() {
        System.out.println("Labour started working.");
    }

   
    public void stopWork() {
        System.out.println("Labour stopped working.");
    }

  
    public void eat() {
        System.out.println("Labour is eating.");
    }

    public void drink() {
        System.out.println("Labour is drinking.");
    }
}