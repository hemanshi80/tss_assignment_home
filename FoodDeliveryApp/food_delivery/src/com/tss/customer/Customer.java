package com.tss.customer;

import java.io.Serializable;

public class Customer implements Serializable {

	  private static final long serialVersionUID = 1L;

	    private String name;
	    private String phone;
	    private String address;
	    private String email;
	    private String username;
	    private String password;

	    public Customer(String name, String phone, String address, String email, String username, String password) {
	        this.name = name;
	        this.phone = phone;
	        this.address = address;
	        this.email = email;
	        this.username = username;
	        this.password = password;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public boolean checkPassword(String inputPassword) {
	        return this.password.equals(inputPassword);
	    }
}