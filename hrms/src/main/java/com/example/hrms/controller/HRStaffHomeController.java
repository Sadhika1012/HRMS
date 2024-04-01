package com.example.hrms.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HRStaffHomeController {

    @GetMapping("/hr/home")
    public String showEmployeeHomePage() {
        // Display the employee home page
        return "hr_home";
    }
}