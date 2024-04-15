package com.example.hrms.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hrms.domain.LeaveRequest;
import com.example.hrms.service.LeaveServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class LeaveListController {

    @Autowired
    private LeaveServiceImpl leaveServiceImpl;

    @GetMapping("/employee/leaves")
    public String showEmployeeLeaveList(Model model, HttpSession session) {
        // Retrieve the userId from the session
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId != null) {
            // Retrieve the list of queries related to the employee based on their userId
            List<LeaveRequest> employeeLeaves = leaveServiceImpl.getRequestsByEmployeeId(userId);
            model.addAttribute("leaves", employeeLeaves);
        }
        // Return the name of the Thymeleaf template for displaying the query list
        return "leaves_employee";
    }

    @GetMapping("/hr/leaves")
    public String showHRLeaveList(Model model) {
        // Retrieve all queries from the query service
        List<LeaveRequest> allLeaves = leaveServiceImpl.getAllRequests();
        model.addAttribute("leaves", allLeaves);
        // Return the name of the Thymeleaf template for displaying the query list
        return "leaves_hr";
    }
}



