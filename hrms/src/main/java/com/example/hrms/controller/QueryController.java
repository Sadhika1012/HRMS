package com.example.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.hrms.domain.Query;
import com.example.hrms.domain.Status;
import com.example.hrms.service.QueryService;

import jakarta.servlet.http.HttpSession;


@Controller

public class QueryController {

    @Autowired
    private QueryService queryService;

    @GetMapping("/employee/post")
public String showPostQueryForm(Model model, HttpSession session) {
    // Retrieve userId from session
    Integer userId = (Integer) session.getAttribute("userId");
    
    // Print userId to console to verify its value
    System.out.println("User ID: " + userId);
    
    // Pass userId to the model attribute
    model.addAttribute("userId", userId);
    
    // Add an empty query object to the model
    model.addAttribute("query", new Query());
    
    // Print session attribute values onto the log
    System.out.println("User ID: " + session.getAttribute("userId"));
    System.out.println("Username: " + session.getAttribute("username"));
    System.out.println("Role: " + session.getAttribute("role"));
    
    return "queryForm";
}

    @PostMapping("/employee/post")
    public String postQuery(@RequestParam("queryText") String queryText, @RequestParam("userId") Integer userId, HttpSession session) {
        // Check if userId is not null
        if (userId != null) {
            // Create a new Query object with the provided queryText and userId
            Query query = new Query(userId, queryText, null,  Status.OPEN);
    
            // Post the query
            queryService.postQuery(query);
    
            // Redirect to query list page
            return "redirect:/employee/queries";
        } else {
            // If userId is null, redirect to the login page
            return "redirect:/login";
        }
    }
    

    @GetMapping("/hr/{queryId}/respond")
    public String showRespondToQueryForm(@PathVariable("queryId") int queryId, Model model) {
        model.addAttribute("queryId", queryId);
        return "queryResponseForm";
    }

    @PostMapping("/hr/{queryId}/respond")
    public String respondToQuery(@PathVariable("queryId") int queryId, @RequestParam("response") String response) {
        queryService.respondToQuery(queryId, response);
        return "redirect:/hr/queries"; // Redirect to query list page
    }
}