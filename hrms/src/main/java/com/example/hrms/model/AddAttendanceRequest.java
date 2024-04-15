package com.example.hrms.model;

import java.time.LocalDateTime;

// AddAttendanceRequest.java
public class AddAttendanceRequest {
    private int employeeId;
    private LocalDateTime checkIn;

    // Getters and setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }
}
