package com.tss.test;

import com.tss.model.IPattern;

public class PatternTest {

	public static void main(String[] args) {

		IPattern print = (rows) ->{

		int num = 1;
		for (int i =1; i<=rows ; i++) 
		{
			for (int j = 1; j<=i ; j++) {
				System.out.print(num +" ");
				num++;
			}
			System.out.println ();
		}
	};
	
	System.out.println("Pattern :");
	print.pattern(3);

}
}
