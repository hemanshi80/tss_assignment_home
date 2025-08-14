package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tss.db.DBConnection;
import com.tss.model.User;

public class UserDao {

	 public boolean registerUser(User user) throws SQLException {
	        String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
	        Connection conn = DBConnection.connect();
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setString(1, user.getUsername());
	        ps.setString(2, user.getPassword());
	        ps.setString(3, user.getEmail());

	        int result = ps.executeUpdate();
	        return result > 0;
	    }
	 
	 public User validateUser(String username, String password) {
		    String query = "SELECT * FROM users WHERE username = ? AND password = ?";
		    try (Connection conn = DBConnection.connect();
		         PreparedStatement ps = conn.prepareStatement(query)) {

		        ps.setString(1, username);
		        ps.setString(2, password);

		        ResultSet rs = ps.executeQuery();
		        if (rs.next()) {
		            User user = new User();
		            user.setId(rs.getInt("id"));
		            user.setUsername(rs.getString("username"));
		            user.setPassword(rs.getString("password"));
		            user.setEmail(rs.getString("email"));
		            return user;
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return null;
		}
	
}
