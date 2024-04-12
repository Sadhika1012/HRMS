package com.example.hrms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hrms.domain.Bonus;
import com.example.hrms.service.BonusService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BonusController {
    @Autowired
    private BonusService bonusService;

    @GetMapping("/hr/bonus")
    public String showAddBonusForm(Model model) {
        model.addAttribute("bonus", new Bonus());
        return "add-bonus";
    }
    

    @PostMapping("/hr/bonus")
    public String addBonus(@ModelAttribute("bonus") Bonus bonus, @RequestParam("employeeId") int employeeId, Model model) {
        try {
            bonus.setEmployeeId(employeeId);
            bonusService.saveBonus(bonus);
            return "redirect:/hr/bonus/view";
        } catch (DataIntegrityViolationException e) {
            // If it's a foreign key constraint violation, display a custom error message
            if (e.getMessage().contains("foreign key constraint")) {
                model.addAttribute("errorMessage", "Invalid employee ID. Please try again.");
            } else {
                // For other types of data integrity violations, display the default error message
                model.addAttribute("errorMessage", e.getMessage());
            }
            // Return the add-bonus page to display the error message and the form again
            return "add-bonus";
        }
    }


    @GetMapping("/hr/bonus/view")
    public String viewAllPayroll(Model model) {
        List<Bonus> bonuses= bonusService.getAllBonus();
        model.addAttribute("bonuses", bonuses);
        return "view-bonus";
    }
    // Other controller methods as needed
    @GetMapping("/employee/bonus")
    public String showEmployeeComplaintList(Model model, HttpSession session) {
        // Retrieve the userId from the session
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId != null) {
            // Retrieve the list of queries related to the employee based on their userId
            List<Bonus> bonuses = bonusService.getBonusByEmployeeId(userId);
            model.addAttribute("bonuses", bonuses);
        }
        // Return the name of the Thymeleaf template for displaying the query list
        return "view_bonus_emp";
    }

}