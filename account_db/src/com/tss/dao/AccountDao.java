package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tss.database.DBConnection;
import com.tss.model.Account;

public class AccountDao {

	 private Connection connection = null;

	    public AccountDao() {
	        this.connection = DBConnection.connect();
	    }

	    public Account getAccountById(int id) throws SQLException {
	        String query = "SELECT * FROM accounts WHERE id = ?";
	        try (PreparedStatement ps = connection.prepareStatement(query)) {
	            ps.setInt(1, id);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    return new Account(
	                        rs.getInt("id"),
	                        rs.getString("name"),
	                        rs.getDouble("balance")
	                    );
	                }
	            }
	        }
	        return null;
	    }

	    public int deductFromAccount(int accountId, double amount) throws SQLException {
	        String sql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
	        try (PreparedStatement ps = connection.prepareStatement(sql)) {
	            ps.setDouble(1, amount);
	            ps.setInt(2, accountId);
	            return ps.executeUpdate();
	        }
	    }

	    public int creditToAccount(int accountId, double amount) throws SQLException {
	        String sql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
	        try (PreparedStatement ps = connection.prepareStatement(sql)) {
	            ps.setDouble(1, amount);
	            ps.setInt(2, accountId);
	            return ps.executeUpdate();
	        }
	    }

	    public Connection getConnection() {
	        return connection;
	    }
}
