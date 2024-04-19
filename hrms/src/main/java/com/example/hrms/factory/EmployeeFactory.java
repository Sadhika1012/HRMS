// EmployeeFactory interface
package com.example.hrms.factory;

import com.example.hrms.domain.Employee;

public interface EmployeeFactory {
    Employee createEmployee(Integer employeeId, String username, String password, String fullName, String email);
}
