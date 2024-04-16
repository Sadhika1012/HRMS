package com.example.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hrms.domain.PayRoll;

// Repository: PayrollStructureRepository.java
@Repository
public interface PayRollRepository extends JpaRepository<PayRoll, Integer> {
    // You can add custom methods if needed
    
    List<PayRoll> findByEmployeeId(int employeeId);
}
