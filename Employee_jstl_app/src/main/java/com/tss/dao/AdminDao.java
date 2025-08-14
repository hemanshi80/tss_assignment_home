package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tss.db.DBConnection;
import com.tss.model.Admin;

public class AdminDao {

    public Admin validateAdmin(String username, String password) {
        String sql = "SELECT admin_id, username, password FROM admin WHERE username = ? AND password = ?";
        Admin admin = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    admin = new Admin();
                    admin.setAdminId(rs.getInt("admin_id"));
                    admin.setUsername(rs.getString("username"));
                    admin.setPassword(rs.getString("password"));
                }
            }

        } catch (Exception e) {
            System.err.println("Error validating admin login: " + e.getMessage());
            e.printStackTrace();
        }

        return admin;
    }
}