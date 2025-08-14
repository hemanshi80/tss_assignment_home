package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.tss.db.DBConnection;

public class ResultDao {

    public void saveResult(int userId, int score) {
        String query = "INSERT INTO results (user_id, score) VALUES (?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, userId);
            ps.setInt(2, score);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
