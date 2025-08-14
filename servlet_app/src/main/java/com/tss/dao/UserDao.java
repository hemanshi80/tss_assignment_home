package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tss.model.User;

public class UserDao {

	public boolean addNewUser(Connection connection , User user) {
		
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT into users (userName , password) values (?,?)");
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			
			int updates;
			updates = statement.executeUpdate();
			
			if (updates > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	 public List<User> getAllUsers(Connection connection) {
         List<User> users = new ArrayList<>();
         String sql = "SELECT userName, password FROM users";

         try (Statement stmt = connection.createStatement();
              ResultSet rs = stmt.executeQuery(sql)) {

             while (rs.next()) {
                 String username = rs.getString("username");
                 String password = rs.getString("password");
                 users.add(new User(username, password));
             }

         } catch (SQLException e) {
             e.printStackTrace();
         }

         return users;
     }
	
}
