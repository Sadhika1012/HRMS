package com.example.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.domain.Bonus;

public interface BonusRepository extends JpaRepository<Bonus, Integer> {
    // You can add custom query methods here if needed
    List<Bonus> findByEmployeeId(int employeeId);
}
