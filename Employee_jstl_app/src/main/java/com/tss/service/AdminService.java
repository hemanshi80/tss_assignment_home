package com.tss.service;

import java.util.List;

import com.tss.dao.AdminDao;
import com.tss.dao.LeaveRequestDao;
import com.tss.model.Admin;
import com.tss.model.LeaveRequest;

public class AdminService {

    private AdminDao adminDao;
    private LeaveRequestDao leaveRequestDao;

    public AdminService() {
        this.adminDao = new AdminDao();
        this.leaveRequestDao = new LeaveRequestDao();
    }

    // Authenticate Admin
    public Admin login(String username, String password) {
        return adminDao.validateAdmin(username, password);
    }

    // Fetch all leave requests
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestDao.getAllLeaveRequests();
    }

    // Approve leave request
    public boolean approveLeave(int requestId) {
        return leaveRequestDao.updateLeaveStatus(requestId, "Approved");
    }

    // Reject leave request
    public boolean rejectLeave(int requestId) {
        return leaveRequestDao.updateLeaveStatus(requestId, "Rejected");
    }
}