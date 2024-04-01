package com.example.hrms.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hr_staff")
public class HRStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hr_id")
    private Integer hrId;

    @Column(name = "employee_id", unique = true)
    private Integer employeeId;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    // Constructors, Getters and Setters
    // Constructors
    public HRStaff() {
    }

    public HRStaff(Integer employeeId, String username, String password) {
        this.employeeId = employeeId;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
