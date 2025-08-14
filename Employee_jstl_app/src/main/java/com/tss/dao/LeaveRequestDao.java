package com.tss.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.db.DBConnection;
import com.tss.model.LeaveRequest;

public class LeaveRequestDao {

    // Add new leave request
    public boolean addLeaveRequest(LeaveRequest request) {
        String sql = "INSERT INTO leave_requests (emp_id, start_date, end_date, reason, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, request.getEmpId());
            ps.setDate(2, Date.valueOf(request.getStartDate())); // LocalDate → SQL Date
            ps.setDate(3, Date.valueOf(request.getEndDate()));   // LocalDate → SQL Date
            ps.setString(4, request.getReason());
            ps.setString(5, request.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get all leave requests
    public List<LeaveRequest> getAllLeaveRequests() {
        List<LeaveRequest> requests = new ArrayList<>();
        String sql = "SELECT * FROM leave_requests";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                LeaveRequest request = new LeaveRequest();
                request.setRequestId(rs.getInt("request_id"));
                request.setEmpId(rs.getInt("emp_id"));

                // SQL Date → LocalDate
                request.setStartDate(rs.getDate("start_date").toLocalDate());
                request.setEndDate(rs.getDate("end_date").toLocalDate());

                request.setReason(rs.getString("reason"));
                request.setStatus(rs.getString("status"));

                requests.add(request);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    // Get leave request by ID
    public LeaveRequest getLeaveRequestById(int requestId) {
        String sql = "SELECT * FROM leave_requests WHERE request_id = ?";
        LeaveRequest request = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, requestId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    request = new LeaveRequest();
                    request.setRequestId(rs.getInt("request_id"));
                    request.setEmpId(rs.getInt("emp_id"));

                    request.setStartDate(rs.getDate("start_date").toLocalDate());
                    request.setEndDate(rs.getDate("end_date").toLocalDate());

                    request.setReason(rs.getString("reason"));
                    request.setStatus(rs.getString("status"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return request;
    }

    // Update leave request status
    public boolean updateLeaveStatus(int requestId, String status) {
        String sql = "UPDATE leave_requests SET status = ? WHERE request_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, requestId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete leave request
    public boolean deleteLeaveRequest(int requestId) {
        String sql = "DELETE FROM leave_requests WHERE request_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, requestId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
