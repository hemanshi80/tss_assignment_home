package com.tss.model;

import java.time.LocalDate;

public class LeaveRequest {
    private int requestId;
    private int empId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private String status;

    // Constructors
    public LeaveRequest() {}

    public LeaveRequest(int requestId, int empId, LocalDate startDate, LocalDate endDate, String reason, String status) {
        this.requestId = requestId;
        this.empId = empId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.status = status;
    }

    // Getters & Setters
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}