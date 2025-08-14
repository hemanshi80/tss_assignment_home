package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tss.db.DBConnection;
import com.tss.exception.DaoException;
import com.tss.model.Feedback;

public class FeedbackDao {

    private static final String INSERT_SQL =
        "INSERT INTO feedback (name, session_date, session_content, query_resolution, interactivity, impactful_learning, content_delivery_skills, comments) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public void saveFeedback(Feedback f) throws DaoException, ClassNotFoundException {
        try (Connection con = DBConnection.connect();
             PreparedStatement ps = con.prepareStatement(INSERT_SQL)) {

            ps.setString(1, f.getName());
            ps.setDate(2, java.sql.Date.valueOf(f.getSessionDate()));
            ps.setInt(3, f.getSessionContent());
            ps.setInt(4, f.getQueryResolution());
            ps.setInt(5, f.getInteractivity());
            ps.setInt(6, f.getImpactfulLearning());
            ps.setInt(7, f.getContentDeliverySkills());
            ps.setString(8, f.getComments());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Failed to save feedback", e);
        }
    }
}