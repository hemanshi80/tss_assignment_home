package com.tss.creational.singleton.model;

public class DatabaseConnection {
	
	public static DatabaseConnection databaseConnection = null;

	public DatabaseConnection() {
		super();
	}
	
	public static DatabaseConnection createInstance() {
		if (databaseConnection == null) {
			databaseConnection = new DatabaseConnection();
	}
		return databaseConnection;
	}
}
