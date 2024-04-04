package com.example.hrms.controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hrms.domain.Query;

import com.example.hrms.service.QueryServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class QueryListController {

    @Autowired
    private QueryServiceImpl queryServiceImpl;

    @GetMapping("/employee/queries")
    public String showEmployeeQueryList(Model model, HttpSession session) {
        // Retrieve the userId from the session
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId != null) {
            // Retrieve the list of queries related to the employee based on their userId
            List<Query> employeeQueries = queryServiceImpl.getQueriesByEmployeeId(userId);
            model.addAttribute("queries", employeeQueries);
        }
        // Return the name of the Thymeleaf template for displaying the query list
        return "queries_employee";
    }

    @GetMapping("/hr/queries")
    public String showHRQueryList(Model model) {
        // Retrieve all queries from the query service
        List<Query> allQueries = queryServiceImpl.getAllQueries();
        model.addAttribute("queries", allQueries);
        // Return the name of the Thymeleaf template for displaying the query list
        return "queries_hr";
    }
}

