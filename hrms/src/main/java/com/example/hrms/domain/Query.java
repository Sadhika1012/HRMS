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
@Table(name = "queries")
public class Query {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "query_id")
    private int queryId;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "query_text")
    private String queryText;

    @Column(name = "response")
    private String response;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    // Default constructor for frameworks like Hibernate
    public Query() {
    }

    // Constructor without builder pattern
    public Query(int employeeId, String queryText, String response, Status status) {
        this.employeeId = employeeId;
        this.queryText = queryText;
        this.response = response;
        this.status = status;
    }

    // Getters
    public int getQueryId() {
        return queryId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getQueryText() {
        return queryText;
    }

    public String getResponse() {
        return response;
    }

    public Status getStatus() {
        return status;
    }

    // Setters
    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
