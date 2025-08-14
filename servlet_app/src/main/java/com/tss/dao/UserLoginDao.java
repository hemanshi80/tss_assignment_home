package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tss.db.DBConnection;
import com.tss.model.UserLogin;

public class UserLoginDao {
	public boolean validateUser(UserLogin user) {
        boolean status = false;

        String sql = "SELECT * FROM users WHERE username = ? AND password = ? AND role = ?";
        try { Connection con = DBConnection.connect();
             PreparedStatement ps = con.prepareStatement(sql); {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                status = true;
            }
             }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
