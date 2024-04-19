package com.example.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.domain.Employee;
import com.example.hrms.factory.EmployeeFactory;
import com.example.hrms.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeFactory employeeFactory;
    @Autowired 
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeFactory employeeFactory, EmployeeRepository employeeRepository) {
        this.employeeFactory = employeeFactory;
        this.employeeRepository = employeeRepository; // Injecting EmployeeRepository
    }

    public Employee createEmployee(int employeeId,String username, String password, String fullName, String email) {
        // Create the Employee entity using the factory
        Employee employee = employeeFactory.createEmployee(employeeId, username, password, fullName, email);
        
        // Save the employee entity to the database
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Add other methods as needed (e.g., CRUD operations)
}

