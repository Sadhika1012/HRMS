package com.example.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;


import com.example.hrms.domain.PayRoll;
import com.example.hrms.service.PayRollService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PayRollController {
    @Autowired
    private PayRollService payRollService;

    @GetMapping("/hr/{payrollId}/add")
    public String showAddPayrollForm(@PathVariable("payrollId") int payrollId, Model model) {
        model.addAttribute("payroll", new PayRoll());
        model.addAttribute("payrollId", payrollId); // Pass the payrollId to the form
        return "add-payroll"; // Assuming you have a Thymeleaf template named "add-payroll.html"
    }

    @PostMapping("/hr/{payrollId}/add")
    public String addPayroll(@PathVariable("payrollId") int payrollId, @ModelAttribute("payroll") PayRoll payroll) {
        
        payroll.setEmployeeId(payrollId); // Set the employee ID
        payRollService.savePayrollStructure(payroll);
        return "redirect:/hr/payroll/view"; // Redirect to the payroll list page
    }
    @GetMapping("/hr/payroll/view")
    public String viewAllPayroll(Model model) {
        List<PayRoll> payrollStructures = payRollService.getAllPayrollStructures();
        model.addAttribute("payrollStructures", payrollStructures);
        return "view_payroll";
    }
    
    // Other controller methods as needed
    @GetMapping("/employee/payroll")
    public String showEmployeeComplaintList(Model model, HttpSession session) {
        // Retrieve the userId from the session
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId != null) {
            // Retrieve the list of queries related to the employee based on their userId
            List<PayRoll> payrollStructures = payRollService.getPayrollByEmployeeId(userId);
            model.addAttribute("payrollStructures", payrollStructures);
        }
        // Return the name of the Thymeleaf template for displaying the query list
        return "view_payroll_emp";
    }

}