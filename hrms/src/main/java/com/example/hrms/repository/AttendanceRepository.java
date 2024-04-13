package com.example.hrms.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.domain.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    // You can add custom query methods here if needed
    List<Attendance> findByEmployeeId(int employeeId);
}
