package com.tss.test;

import com.tss.model.IWorker;
import com.tss.model.Labour;
import com.tss.model.Robot;


public class WorkerTest {

	public static void main(String[] args) {
		
		 IWorker labour = new Labour();
	        labour.startWork();
	        labour.eat();
	        labour.drink();
	        labour.stopWork();
	        
	        IWorker robo = new Robot();
	        robo.startWork();
	        robo.stopWork();
	        
	        

	}

}
