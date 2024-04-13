// AttendanceService.java
package com.example.hrms.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hrms.domain.Attendance;
import com.example.hrms.repository.AttendanceRepository;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> updateAttendance(int attendanceId, LocalDateTime checkOut) {
        // Retrieve the attendance record by ID
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(attendanceId);
        
        if (optionalAttendance.isPresent()) {
            Attendance attendance = optionalAttendance.get();
            attendance.setCheckOut(checkOut);
            
            // Save the updated attendance record
            attendanceRepository.save(attendance);
            
            // Return the updated attendance record
            return Collections.singletonList(attendance);
        } else {
            // Handle if attendance record with given ID does not exist
            // You can throw an exception or handle it based on your application's requirements
            return Collections.emptyList();
        }
    }
    

    public void addAttendance(int employeeId, LocalDateTime checkIn) {
        // Implement logic to add new attendance
        Attendance attendance = new Attendance(employeeId, checkIn);
        attendanceRepository.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public List<Attendance> getAttendanceByEmployeeId(int employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }

}
