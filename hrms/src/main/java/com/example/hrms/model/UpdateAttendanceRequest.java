package com.example.hrms.model;

import java.time.LocalDateTime;

// UpdateAttendanceRequest.java
public class UpdateAttendanceRequest {
    private int attendanceId;
    private int employeeId;
    private LocalDateTime checkOut;

    // Getters and setters
    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    // Getters and setters
    public int getEmployeeId() {
        return employeeId;
    }


    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }
}

