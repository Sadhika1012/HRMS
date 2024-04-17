package com.example.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hrms.domain.Complaint;
import com.example.hrms.domain.Status;
import com.example.hrms.domain.decorators.UrgentComplaintDecorator;
import com.example.hrms.service.ComplaintService;

import jakarta.servlet.http.HttpSession;

@Controller

public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @GetMapping("/employee/post_complaint")
public String showPostComplaintForm(Model model, HttpSession session) {
    // Retrieve userId from session
    Integer userId = (Integer) session.getAttribute("userId");
    
    // Print userId to console to verify its value
    System.out.println("User ID: " + userId);
    
    // Pass userId to the model attribute
    model.addAttribute("userId", userId);
    
    // Add an empty query object to the model
    model.addAttribute("complaint", new Complaint());
    
    return "complaintForm";
}

    @PostMapping("/employee/post_complaint")
    public String postComplaint(@RequestParam("complaintText") String complaintText, @RequestParam("userId") Integer userId, HttpSession session) {
        // Check if userId is not null
        if (userId != null) {
            // Create a new Complaint object with the provided complaintText and userId
        Complaint complaint = new Complaint(userId, complaintText, null,  Status.OPEN);
        
        // Wrap the complaint with UrgentComplaintDecorator if needed
        UrgentComplaintDecorator urgentComplaint = new UrgentComplaintDecorator(complaint);

        // Apply escalation logic
        urgentComplaint.escalate(); // Apply escalation logic
        
        
        // Post the complaint
        complaintService.postComplaint(urgentComplaint.getComplaint()); // Pass the original complaint
        
    
            // Redirect to query list page
            return "redirect:/employee/complaints";
        } else {
            // If userId is null, redirect to the login page
            return "redirect:/login";
        }
    }
    

    @GetMapping("/hr/{complaintId}/response")
    public String showRespondToComplaintForm(@PathVariable("complaintId") int complaintId, Model model) {
        model.addAttribute("complaintId", complaintId);
        return "complaintResponse";
    }

    @PostMapping("/hr/{complaintId}/response")
    public String respondToComplaint(@PathVariable("complaintId") int complaintId, @RequestParam("resolution") String resolution) {
        complaintService.respondToComplaint(complaintId, resolution);
        return "redirect:/hr/complaints"; // Redirect to query list page
    }
}
