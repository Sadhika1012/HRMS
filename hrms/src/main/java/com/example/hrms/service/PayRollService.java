package com.example.hrms.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.domain.PayRoll;
import com.example.hrms.repository.PayRollRepository;



// Service: PayrollStructureService.java
@Service
public class PayRollService {
 
    @Autowired
    private PayRollRepository payrollStructureRepository;
    
    
    public PayRoll savePayrollStructure(PayRoll payrollStructure) {
        return payrollStructureRepository.save(payrollStructure);
    }

    // Other service methods as needed
    public List<PayRoll> getAllPayrollStructures() {
        return payrollStructureRepository.findAll();
    }

    public List<PayRoll> getPayrollByEmployeeId(int employeeId) {
        return payrollStructureRepository.findByEmployeeId(employeeId);
    }

    
   

    
}

