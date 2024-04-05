package com.example.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.domain.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {
    // You can add custom query methods here if needed
    List<Complaint> findByEmployeeId(int employeeId);
}

