package com.example.hrms.service.command;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.hrms.service.AttendanceService;

@Component
public class UpdateAttendanceCommand implements AttendanceCommand {
    private final AttendanceService attendanceService;
    private int attendanceId;
    private LocalDateTime checkOut;

    public UpdateAttendanceCommand(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public void execute() {
        attendanceService.updateAttendance(attendanceId, checkOut);
    }
}
