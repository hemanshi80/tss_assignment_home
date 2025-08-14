package com.tss.service;

import com.tss.dao.EmployeeDao;
import com.tss.dao.LeaveRequestEmployeeDao;
import com.tss.db.DBConnection;
import com.tss.model.LeaveRequest;

import java.sql.Connection;
import java.sql.SQLException;

public class EmployeeService {

    private final EmployeeDao empDao = new EmployeeDao();
    private final LeaveRequestEmployeeDao leaveDao = new LeaveRequestEmployeeDao();

    /** Submit leave request */
    public String submitLeave(LeaveRequest r) {
        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            // Lock employee balances
            double[] balances = empDao.lockAndGetBalances(con, r.getEmpId());
            if (balances == null) {
                con.rollback();
                return "Employee not found";
            }

            double requestedDays = r.getNumberOfDays();
            if (r.getLeaveType().equalsIgnoreCase("PLANNED") && balances[0] < requestedDays) {
                con.rollback();
                return "Insufficient planned leave balance";
            }
            if (r.getLeaveType().equalsIgnoreCase("UNPLANNED") && balances[1] < requestedDays) {
                con.rollback();
                return "Insufficient unplanned leave balance";
            }

            // Insert leave request
            leaveDao.addLeaveRequest(con, r);

            con.commit();
            return "Leave request submitted successfully";

        } catch (SQLException e) {
            return "Error submitting leave: " + e.getMessage();
        }
    }

    /** Cancel leave request */
    public String cancelLeave(int requestId, int empId) {
        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            boolean ok = leaveDao.cancelLeaveRequest(con, requestId, empId);
            if (!ok) {
                con.rollback();
                return "Cannot cancel leave (already processed or not found)";
            }

            con.commit();
            return "Leave request cancelled successfully";
        } catch (SQLException e) {
            return "Error cancelling leave: " + e.getMessage();
        }
    }
}
