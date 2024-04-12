package com.example.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.domain.Bonus;
import com.example.hrms.repository.BonusRepository;

@Service
public class BonusService {
 
    @Autowired
    private BonusRepository bonusRepository;
    
    
    public Bonus saveBonus(Bonus bonus) {
        return bonusRepository.save(bonus);
    }

    // Other service methods as needed
    public List<Bonus> getAllBonus() {
        return bonusRepository.findAll();
    }

    public List<Bonus> getBonusByEmployeeId(int employeeId) {
        return bonusRepository.findByEmployeeId(employeeId);
    }

    
   

    
}
