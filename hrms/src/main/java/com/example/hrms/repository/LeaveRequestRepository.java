package com.example.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.domain.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {
    // You can add custom query methods here if needed
    List<LeaveRequest> findByEmployeeId(int employeeId);
}
