package com.example.hrms.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_bonus")
public class Bonus {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bonus_id")
    private int bonusId;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "bonus_amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal bonusAmount;

    @Column(name = "bonus_reason")
    private String bonusReason;

    // Constructors, getters, and setters
    // Constructors
    public Bonus() {
    }

    public Bonus(int employeeId, BigDecimal bonusAmount, String bonusReason) {
        this.employeeId = employeeId;
        this.bonusAmount = bonusAmount;
        this.bonusReason = bonusReason;
    }

    // Getters and setters
    public int getBonusId() {
        return bonusId;
    }

    public void setBonusId(int bonusId) {
        this.bonusId = bonusId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(BigDecimal bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public String getBonusReason() {
        return bonusReason;
    }

    public void setBonusReason(String bonusReason) {
        this.bonusReason = bonusReason;
    }
}