package com.tss.model;

public class Robot implements IWorker{

	
    public void startWork() {
        System.out.println("Robot started working.");
    }

    public void stopWork() {
        System.out.println("Robot stopped working.");
    }

    public void eat() {
        // Forced implementation - not needed
        throw new UnsupportedOperationException("Robot doesn't eat.");
    }

    public void drink() {
        // Forced implementation - not needed
        throw new UnsupportedOperationException("Robot doesn't drink.");
    }
}
