package com.example.hrms.service.command;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.hrms.service.AttendanceService;

@Component
public class AddAttendanceCommand implements AttendanceCommand {
    private final AttendanceService attendanceService;
    private  int employeeId;
    private  LocalDateTime checkIn;

    public AddAttendanceCommand(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    @Override
    public void execute() {
        attendanceService.addAttendance(employeeId, checkIn);
    }
}

