package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tss.db.DBConnection;
import com.tss.model.Admin;

public class AdminDao {

    /** Login and fetch admin details from DB (adminId is retrieved, not set manually) */
    public Admin login(String username, String password) throws SQLException {
        String sql = "SELECT admin_id, username FROM admin WHERE username=? AND password=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Admin admin = new Admin();
                    admin.setAdminId(rs.getInt("admin_id")); // auto-generated from DB
                    admin.setUsername(rs.getString("username"));
                    return admin;
                }
            }
        }
        return null;
    }

    /** Count total pending leave requests */
    public int countPendingRequests() throws SQLException {
        String sql = "SELECT COUNT(*) FROM leave_requests WHERE status='PENDING'";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }
}