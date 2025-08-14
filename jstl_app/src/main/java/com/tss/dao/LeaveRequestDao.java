package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tss.db.DBConnection;
import com.tss.model.LeaveRequest;

public class LeaveRequestDao {

    // ================== Admin Methods ===================
    public List<LeaveRequest> findAllPending() throws SQLException {
        String sql = """
            SELECT lr.request_id, lr.emp_id, e.emp_name, lr.start_date, lr.end_date,
                   lr.reason, lr.status, lr.leave_type, lr.duration, lr.number_of_days
            FROM leave_requests lr
            JOIN employee e ON e.emp_id = lr.emp_id
            WHERE lr.status='PENDING'
            ORDER BY lr.created_at DESC
        """;
        List<LeaveRequest> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

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
                list.add(r);
            }
        }
        return list;
    }

    public Object[] lockAndGetForDecision(Connection con, int requestId) throws SQLException {
        String sql = """
            SELECT emp_id, number_of_days, leave_type 
            FROM leave_requests 
            WHERE request_id=? AND status='PENDING' 
            FOR UPDATE
        """;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, requestId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                return new Object[]{
                    rs.getInt("emp_id"),
                    rs.getDouble("number_of_days"),
                    rs.getString("leave_type")
                };
            }
        }
    }

    public boolean markApproved(Connection con, int requestId, int adminId) throws SQLException {
        String sql = """
            UPDATE leave_requests 
            SET status='APPROVED', processed_by_admin=?, updated_at=NOW() 
            WHERE request_id=? AND status='PENDING'
        """;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, adminId);
            ps.setInt(2, requestId);
            return ps.executeUpdate() == 1;
        }
    }

    public boolean markRejected(Connection con, int requestId, int adminId) throws SQLException {
        String sql = """
            UPDATE leave_requests 
            SET status='REJECTED', processed_by_admin=?, updated_at=NOW() 
            WHERE request_id=? AND status='PENDING'
        """;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, adminId);
            ps.setInt(2, requestId);
            return ps.executeUpdate() == 1;
        }
    }

    // ================== Employee Methods ===================

    /** Find all leave requests of a specific employee */
    public List<LeaveRequest> findByEmployee(int empId) throws SQLException {
        String sql = """
            SELECT request_id, emp_id, start_date, end_date, reason, status, 
                   leave_type, duration, number_of_days, processed_by_admin, created_at, updated_at
            FROM leave_requests
            WHERE emp_id=?
            ORDER BY created_at DESC
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

    /** Add a new leave request */
    public int addLeaveRequest(Connection con, LeaveRequest lr) throws SQLException {
        String sql = """
            INSERT INTO leave_requests
            (emp_id, start_date, end_date, reason, status, leave_type, duration, number_of_days, created_at, updated_at)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())
        """;
        try (PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, lr.getEmpId());
            ps.setDate(2, java.sql.Date.valueOf(lr.getStartDate()));
            ps.setDate(3, java.sql.Date.valueOf(lr.getEndDate()));
            ps.setString(4, lr.getReason());
            ps.setString(5, lr.getStatus());
            ps.setString(6, lr.getLeaveType());
            ps.setString(7, lr.getDuration());
            ps.setDouble(8, lr.getNumberOfDays());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        lr.setRequestId(rs.getInt(1));
                    }
                }
            }
            return rows;
        }
    }

    /** Cancel leave request by employee */
    public boolean cancelByEmployee(Connection con, int requestId, int empId) throws SQLException {
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
