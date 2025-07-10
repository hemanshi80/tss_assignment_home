package com.tss.model;

public class Labour2 implements IWorker2{

	 
	    public void start() {
	        System.out.println("Labour started working.");
	    }

	    public void stop() {
	        System.out.println("Labour stopped working.");
	    }

	    
	    public void eat() {
	        System.out.println("Labour is eating lunch.");
	    }

	    public void rest() {
	        System.out.println("Labour is taking rest.");
	    }
}
