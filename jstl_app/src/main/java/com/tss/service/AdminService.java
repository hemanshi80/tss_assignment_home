package com.tss.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.tss.dao.EmployeeDao;
import com.tss.dao.LeaveRequestDao;
import com.tss.db.DBConnection;

public class AdminService {

    private final LeaveRequestDao leaveDao = new LeaveRequestDao();
    private final EmployeeDao empDao = new EmployeeDao();

    public String approve(int requestId, int adminId) {
        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            // Fetch and lock leave request row
            Object[] rec = leaveDao.lockAndGetForDecision(con, requestId);
            if (rec == null) {
                con.rollback();
                return "Request not found or not pending.";
            }

            int empId = (Integer) rec[0];         // emp_id from DB
            double days = (Double) rec[1];        // number_of_days from DB
            String type = (String) rec[2];        // leave_type from DB

            // Lock employee balances
            double[] balances = empDao.lockAndGetBalances(con, empId);
            if (balances == null) {
                con.rollback();
                return "Employee not found.";
            }

            Savepoint sp = con.setSavepoint("before_deduct");

            // Deduct leave
            int updated = empDao.deduct(con, empId, type, days);
            if (updated != 1) {
                con.rollback(sp);
                con.setAutoCommit(true);
                return "Insufficient " + type.toLowerCase() + " leave balance.";
            }

            // Mark approved in leave request table
            boolean ok = leaveDao.markApproved(con, requestId, adminId);
            if (!ok) {
                con.rollback(sp);
                con.setAutoCommit(true);
                return "Request already processed by someone else.";
            }

            con.commit();
            con.setAutoCommit(true);
            return "Approved successfully.";
        } catch (SQLException e) {
            return "Error approving: " + e.getMessage();
        }
    }

    public String reject(int requestId, int adminId) {
        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            // Fetch and lock leave request row
            Object[] rec = leaveDao.lockAndGetForDecision(con, requestId);
            if (rec == null) {
                con.rollback();
                return "Request not found or not pending.";
            }

            // Mark rejected
            boolean ok = leaveDao.markRejected(con, requestId, adminId);
            if (!ok) {
                con.rollback();
                return "Request already processed.";
            }

            con.commit();
            con.setAutoCommit(true);
            return "Rejected successfully.";
        } catch (SQLException e) {
            return "Error rejecting: " + e.getMessage();
        }
    }
}