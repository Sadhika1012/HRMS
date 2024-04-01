package com.example.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hrms.domain.HRStaff;

@Repository
public interface HRStaffRepository extends JpaRepository<HRStaff, Integer> {
    HRStaff findByUsername(String username);
}
