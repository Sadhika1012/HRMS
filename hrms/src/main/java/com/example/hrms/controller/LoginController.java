package com.example.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hrms.model.LoginRequest;
import com.example.hrms.service.AuthenticationService;

import com.example.hrms.domain.UserRole; // Import UserRole enum

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/employee/login")
    public String showEmployeeLoginForm(Model model) {
        // Add an empty LoginRequest object to the model
        model.addAttribute("loginRequest", new LoginRequest());
        return "employee_login";
    }

    @PostMapping("/employee/login")
    public String employeeLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model) {
        // Authenticate the user and retrieve the user ID if authentication is successful
        int userId = authenticationService.authenticateAndGetUserId(username, password, UserRole.EMPLOYEE);
        
        if (userId != -1) {
            // Employee authentication successful, redirect to employee home page
            session.setAttribute("userId", userId); // Store user ID in session
            session.setAttribute("username", username); // Store username in session for further use
            session.setAttribute("role", UserRole.EMPLOYEE);
             // Print session attribute values to console
        System.out.println("User ID: " + session.getAttribute("userId"));
        System.out.println("Username: " + session.getAttribute("username"));
        System.out.println("Role: " + session.getAttribute("role"));

            return "redirect:/employee/home"; // Return the HTML page name
        } else {
            // Authentication failed, redirect back to employee login page with error message
            model.addAttribute("error", true); // Set error flag to true
            return "employee_login"; // Return the HTML page name
        }
    }


    @GetMapping("/")
    public String showHRLoginForm(Model model) {
        // Add an empty LoginRequest object to the model
        model.addAttribute("loginRequest", new LoginRequest());
        return "hr_login";
    }

    @PostMapping("/")
    public String hrLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model) {
        // Authenticate the user and retrieve the user ID if authentication is successful
        int userId = authenticationService.authenticateAndGetUserId(username, password, UserRole.HR);
        
        if (userId != -1) {
            // HR authentication successful, redirect to HR home page
            session.setAttribute("userId", userId); // Store user ID in session
            session.setAttribute("username", username);
            session.setAttribute("role", UserRole.HR); // Store username in session for further use
            return "redirect:/hr/home"; // Return the HTML page name
        } else {
            // Authentication failed, redirect back to HR login page with error message
            model.addAttribute("error", true); // Set error flag to true
            return "hr_login"; // Return the HTML page name
        }
    }
}
