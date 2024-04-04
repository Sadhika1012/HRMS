package com.example.hrms.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.domain.Query;

public interface QueryRepository extends JpaRepository<Query, Integer> {
    // You can add custom query methods here if needed
    List<Query> findByEmployeeId(int employeeId);
}
