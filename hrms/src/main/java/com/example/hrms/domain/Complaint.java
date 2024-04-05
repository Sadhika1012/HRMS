package com.example.hrms.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "complaints")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaint_id")
    private int complaintId;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "complaint_text")
    private String complaintText;

    @Column(name = "resolution")
    private String resolution;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    // Default constructor for frameworks like Hibernate
    public Complaint() {
    }

    // Constructor without builder pattern
    public Complaint(int employeeId, String complaintText, String resolution, Status status) {
        this.employeeId = employeeId;
        this.complaintText = complaintText;
        this.resolution = resolution;
        this.status = status;
    }

    // Getters and setters

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getComplaintText() {
        return complaintText;
    }

    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
