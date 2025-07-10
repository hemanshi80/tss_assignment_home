package com.tss.creational.singleton.test;

import com.tss.creational.singleton.model.DatabaseConnection;

public class SingeltonTest {

	public static void main(String[] args) {
		
		DatabaseConnection connection = DatabaseConnection.createInstance();
		System.out.println(connection.hashCode());
		DatabaseConnection connection2 = DatabaseConnection.createInstance();
		System.out.println(connection2.hashCode());
		DatabaseConnection connection3 = DatabaseConnection.createInstance();
		System.out.println(connection3.hashCode());
		DatabaseConnection connection4 = DatabaseConnection.createInstance();
		System.out.println(connection4.hashCode());

	}

}
