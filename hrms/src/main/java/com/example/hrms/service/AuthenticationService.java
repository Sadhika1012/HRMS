package com.example.hrms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.domain.UserRole;

import com.example.hrms.domain.Login;
import com.example.hrms.repository.LoginRepository;

@Service
public class AuthenticationService {

    @Autowired
    private LoginRepository loginRepository;

    public boolean authenticate(String username, String password, UserRole role) {
        Login login = loginRepository.findByUsernameAndRole(username, role);
        if (login != null && login.getPassword().equals(password)) {
            // Authentication successful
            return true;
        }
        // Authentication failed
        return false;
    }

    public int authenticateAndGetUserId(String username, String password, UserRole role) {
    Login login = loginRepository.findByUsernameAndRole(username, role);
    if (login != null && login.getPassword().equals(password)) {
        if (role == UserRole.HR) {
           
                return login.getHrId(); // Return HR ID if the role is HR
        }
        else {
            // For other roles, return the employee ID
            return login.getEmployeeId();
        }
        
    }
    return -1; // Return -1 if authentication fails or if the role is not HR and no employee ID found
}

}
