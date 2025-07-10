package com.tss.model;

public class InputValidator {

	String username ;
	String password;
	String email;
	
	public InputValidator(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public static boolean validateUsername(String username) {
		if (isEmpty(username)&&isNull(username)) {
			return false;
		}
		
		return length(username , 3 , 20);
	}
	
	public static boolean validatePassword(String password) {
		if (isEmpty(password)&&isNull(password)) {
			return false;
		}
		return length(password , 8 , 30) ;

	}
	

	public static boolean validateEmail(String email) {
		{if (isEmpty(email) && isNull(email)) 
			return false;
		}
		return length(email , 5 , 50) && email.contains(".") && email.contains("@");
	}
	
	
	public static boolean isEmpty(String var) {
		if(var.length()== 0) {
			return true;
		}
		return false;
	}
	
	
	public static boolean isNull(String var2) {
		if(var2 == null) {
			return true;
		}
		return false;
	}
	
	
	public static boolean length (String str , int min , int max) {
		int len = str.length();
		return len>= min && len <= max;
	}
	
	
}
