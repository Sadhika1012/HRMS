package com.example.hrms.service.factory;

import java.math.BigDecimal;

import com.example.hrms.domain.PayRoll;

public class PayRollFactory {
    public static PayRoll createPayroll(int payrollId, int employeeId, String position, BigDecimal baseSalary) {
        PayRoll payrollStructure = new PayRoll();
        payrollStructure.setPayrollId(payrollId);
        payrollStructure.setEmployeeId(employeeId);
        payrollStructure.setPosition(position);
        payrollStructure.setBaseSalary(baseSalary);
        return payrollStructure;
    }
}

