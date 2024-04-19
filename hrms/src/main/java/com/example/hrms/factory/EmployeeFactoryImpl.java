// EmployeeFactoryImpl implementation
package com.example.hrms.factory;

import org.springframework.stereotype.Component;

import com.example.hrms.domain.Employee;

@Component
public class EmployeeFactoryImpl implements EmployeeFactory {

    @Override
    public Employee createEmployee(Integer employeeId, String username, String password, String fullName, String email) {
        // You can implement any additional logic here, such as validation
        return new Employee(employeeId, username, password, fullName, email);
    }
}
