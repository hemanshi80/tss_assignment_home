package com.tss.dao;

import com.tss.db.DBConnection;
import com.tss.model.LeaveRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeaveRequestEmployeeDao {

    /** Insert a new leave request */
    public int addLeaveRequest(Connection con, LeaveRequest r) throws SQLException {
        String sql = """
            INSERT INTO leave_requests
            (emp_id, start_date, end_date, reason, status, leave_type, duration, number_of_days, created_at, updated_at)
            VALUES (?, ?, ?, ?, 'PENDING', ?, ?, ?, NOW(), NOW())
        """;
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, r.getEmpId());
            ps.setDate(2, Date.valueOf(r.getStartDate()));
            ps.setDate(3, Date.valueOf(r.getEndDate()));
            ps.setString(4, r.getReason());
            ps.setString(5, r.getLeaveType());
            ps.setString(6, r.getDuration());
            ps.setDouble(7, r.getNumberOfDays());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        r.setRequestId(rs.getInt(1));
                    }
                }
            }
            return rows;
        }
    }

    /** Fetch all leave requests of an employee */
    public List<LeaveRequest> getByEmployee(int empId) throws SQLException {
        String sql = """
            SELECT lr.*, e.emp_name
            FROM leave_requests lr
            JOIN employee e ON e.emp_id = lr.emp_id
            WHERE lr.emp_id=?
            ORDER BY lr.created_at DESC
        """;
        List<LeaveRequest> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, empId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LeaveRequest r = new LeaveRequest();
                    r.setRequestId(rs.getInt("request_id"));
                    r.setEmpId(rs.getInt("emp_id"));
                    r.setEmpName(rs.getString("emp_name"));
                    r.setStartDate(rs.getDate("start_date").toLocalDate());
                    r.setEndDate(rs.getDate("end_date").toLocalDate());
                    r.setReason(rs.getString("reason"));
                    r.setStatus(rs.getString("status"));
                    r.setLeaveType(rs.getString("leave_type"));
                    r.setDuration(rs.getString("duration"));
                    r.setNumberOfDays(rs.getDouble("number_of_days"));
                    r.setProcessedByAdmin(rs.getString("processed_by_admin"));
                    r.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                    r.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                    list.add(r);
                }
            }
        }
        return list;
    }

    /** Cancel leave request by employee (only PENDING or APPROVED leaves) */
    public boolean cancelLeaveRequest(Connection con, int requestId, int empId) throws SQLException {
        String sql = """
            UPDATE leave_requests 
            SET status='CANCELLED_BY_EMPLOYEE', updated_at=NOW() 
            WHERE request_id=? AND emp_id=? AND status IN ('PENDING','APPROVED')
        """;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, requestId);
            ps.setInt(2, empId);
            return ps.executeUpdate() == 1;
        }
    }
}