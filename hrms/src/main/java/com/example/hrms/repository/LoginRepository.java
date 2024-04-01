package com.example.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hrms.domain.Login;
import com.example.hrms.domain.UserRole;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Login findByUsernameAndRole(String username, UserRole role);
}
