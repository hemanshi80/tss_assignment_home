package com.tss.test.exception_handling;

public class Test {

	public static void main(String[] args) {
		 
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		try {
			float result = num1/num2;
			float add = num1+num2;
			System.out.println("Division:" + result);
			System.out.println("Result:" + add);
			
		}
		
		catch(Exception exception){
			
			System.out.println("Some Error occured!!" + exception.getMessage());
		}
		
		
		finally {
			System.out.println("Inside Finally");
		}
		
		System.out.println("Thanks");

	}

}
