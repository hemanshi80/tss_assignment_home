package com.tss.test.exception_handling;

import com.tss.model.exception_handling.Voter;

public class VoterTest {

	public static void main(String[] args) {
		try
		{
			Voter voter = new Voter("Hemanshi",210,19);
			System.out.println(voter.toString());
			Voter voter2 = new Voter("Deep",310,10);
			System.out.println(voter2.toString());
			
		}
		catch(Exception exception)
		{
			System.out.println(exception);
		}
	}

}


