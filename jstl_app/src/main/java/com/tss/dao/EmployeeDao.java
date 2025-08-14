package com.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tss.db.DBConnection;
import com.tss.model.Employee;

public class EmployeeDao {
	/** Login by employee name */
	public Employee login(String empName) throws SQLException {
	    String sql = """
	        SELECT emp_id, emp_name, department, planned_leave_balance, 
	               unplanned_leave_balance, leave_balance
	        FROM employee
	        WHERE emp_name = ?
	    """;
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setString(1, empName);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                Employee e = new Employee();
	                e.setEmpId(rs.getInt("emp_id"));
	                e.setEmpName(rs.getString("emp_name"));
	                e.setDepartment(rs.getString("department"));
	                e.setPlannedLeaveBalance(rs.getDouble("planned_leave_balance"));
	                e.setUnplannedLeaveBalance(rs.getDouble("unplanned_leave_balance"));
	                e.setTotalLeaveBalance(rs.getDouble("leave_balance"));
	                return e;
	            }
	        }
	    }
	    return null;
	}
	
    /** Lock employee row for update and return [planned, unplanned] leave balances */
    public double[] lockAndGetBalances(Connection con, int empId) throws SQLException {
        String sql = """
            SELECT planned_leave_balance, unplanned_leave_balance 
            FROM employee 
            WHERE emp_id=? 
            FOR UPDATE
        """;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, empId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                return new double[]{ rs.getDouble(1), rs.getDouble(2) };
            }
        }
    }

    /** Deduct leave and refresh total leave balance */
    public int deduct(Connection con, int empId, String leaveType, double days) throws SQLException {
        String col = leaveType.equalsIgnoreCase("PLANNED") ? 
                     "planned_leave_balance" : "unplanned_leave_balance";

        String sql = "UPDATE employee SET " + col + " = " + col + " - ?, " +
                     "leave_balance = planned_leave_balance + unplanned_leave_balance " +
                     "WHERE emp_id=? AND " + col + " >= ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, days);
            ps.setInt(2, empId);
            ps.setDouble(3, days);
            return ps.executeUpdate();
        }
    }

    /** Fetch employee details by ID */
    public Employee getById(int empId) throws SQLException {
        String sql = """
            SELECT emp_id, emp_name, department, planned_leave_balance, 
                   unplanned_leave_balance, leave_balance
            FROM employee 
            WHERE emp_id=?
        """;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, empId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Employee e = new Employee();
                    e.setEmpId(rs.getInt("emp_id"));
                    e.setEmpName(rs.getString("emp_name"));
                    e.setDepartment(rs.getString("department"));
                    e.setPlannedLeaveBalance(rs.getDouble("planned_leave_balance"));
                    e.setUnplannedLeaveBalance(rs.getDouble("unplanned_leave_balance"));
                    e.setTotalLeaveBalance(rs.getDouble("leave_balance"));
                    return e;
                }
            }
        }
        return null;
    }

    /** Fetch all employees */
    public List<Employee> getAll() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = """
            SELECT emp_id, emp_name, department, planned_leave_balance, 
                   unplanned_leave_balance, leave_balance 
            FROM employee
        """;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Employee e = new Employee();
                e.setEmpId(rs.getInt("emp_id"));
                e.setEmpName(rs.getString("emp_name"));
                e.setDepartment(rs.getString("department"));
                e.setPlannedLeaveBalance(rs.getDouble("planned_leave_balance"));
                e.setUnplannedLeaveBalance(rs.getDouble("unplanned_leave_balance"));
                e.setTotalLeaveBalance(rs.getDouble("leave_balance"));
                list.add(e);
            }
        }
        return list;
    }

    /** Add a new employee (empId auto-generated by DB) */
    public int add(Employee e) throws SQLException {
        String sql = """
            INSERT INTO employee 
            (emp_name, department, planned_leave_balance, unplanned_leave_balance, leave_balance) 
            VALUES (?, ?, ?, ?, ?)
        """;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, e.getEmpName());
            ps.setString(2, e.getDepartment());
            ps.setDouble(3, e.getPlannedLeaveBalance());
            ps.setDouble(4, e.getUnplannedLeaveBalance());
            ps.setDouble(5, e.getTotalLeaveBalance());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        e.setEmpId(rs.getInt(1)); // auto-generated ID from DB
                    }
                }
            }
            return rows;
        }
    }
}