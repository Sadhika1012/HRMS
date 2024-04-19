package com.example.hrms.model;

public class EmployeeRequest {
     // New field for employeeId
    private String username;
    private String password;
    private String fullName;
    private String email;

    private Integer employeeId = 3; // Default value for employeeId

    // Other attributes and methods...

    // Getter and setter for employeeId
    public Integer getEmployeeId() {
        return employeeId != null ? employeeId : 3;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    // Method to increment employeeId
    public void incrementEmployeeId() {
        if (employeeId != null) {
            employeeId++;
        }
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
