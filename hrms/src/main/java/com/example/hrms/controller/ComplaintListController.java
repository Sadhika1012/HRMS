package com.example.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hrms.domain.Complaint;
import com.example.hrms.service.ComplaintServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class ComplaintListController {

    @Autowired
    private ComplaintServiceImpl complaintServiceImpl;

    @GetMapping("/employee/complaints")
    public String showEmployeeComplaintList(Model model, HttpSession session) {
        // Retrieve the userId from the session
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId != null) {
            // Retrieve the list of queries related to the employee based on their userId
            List<Complaint> employeeComplaints = complaintServiceImpl.getComplaintsByEmployeeId(userId);
            model.addAttribute("complaints", employeeComplaints);
        }
        // Return the name of the Thymeleaf template for displaying the query list
        return "complaints_employee";
    }

    @GetMapping("/hr/complaints")
    public String showHRComplaintList(Model model) {
        // Retrieve all queries from the query service
        List<Complaint> allComplaints = complaintServiceImpl.getAllComplaints();
        model.addAttribute("complaints", allComplaints);
        // Return the name of the Thymeleaf template for displaying the query list
        return "complaints_hr";
    }
}


