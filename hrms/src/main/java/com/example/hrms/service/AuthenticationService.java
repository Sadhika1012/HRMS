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
}
