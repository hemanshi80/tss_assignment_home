package com.tss.model;

public class Employee {
    private int empId;
    private String empName;
    private String department;
    private int leaveBalance;

    // Constructors
    public Employee() {}

    public Employee(int empId, String empName, String department, int leaveBalance) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.leaveBalance = leaveBalance;
    }

    // Getters & Setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }
}
