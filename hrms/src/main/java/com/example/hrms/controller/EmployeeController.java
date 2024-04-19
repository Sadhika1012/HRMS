package com.example.hrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hrms.model.EmployeeRequest;
import com.example.hrms.service.EmployeeService;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/hr/employees")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employeeRequest", new EmployeeRequest());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "add_employee"; // Thymeleaf template name
    }

    @PostMapping("/hr/employees")
    public String createEmployee(EmployeeRequest employeeRequest) {
        employeeService.createEmployee(employeeRequest.getEmployeeId(),
                                       employeeRequest.getUsername(),
                                       employeeRequest.getPassword(),
                                       employeeRequest.getFullName(),
                                       employeeRequest.getEmail());
                                       // Debugging statement
        
        return "redirect:/hr/employees"; // Redirect to the form page
    }
}
