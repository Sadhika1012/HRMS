package com.example.hrms.controller;

import com.example.hrms.domain.LeaveRequest;
import com.example.hrms.domain.ApprovalStatus;
import com.example.hrms.service.LeaveService;

import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class LeaveController {
    @Autowired
    private  LeaveService leaveService;

    
    

    @GetMapping("/employee/post_leave")
    public String showPostLeaveForm(Model model, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        model.addAttribute("userId", userId);
        model.addAttribute("leave", new LeaveRequest());
        return "leaveForm";
    }

    @PostMapping("/employee/post_leave")
    public String postLeaveRequest(@RequestParam("startDate") LocalDate startDate,
                                   @RequestParam("endDate") LocalDate endDate,
                                   @RequestParam("userId") Integer userId,
                                   HttpSession session) {
        if (userId != null) {
            LeaveRequest leaveRequest = new LeaveRequest(userId, startDate, endDate, ApprovalStatus.PENDING);
            leaveService.postLeaveRequest(leaveRequest);
            return "redirect:/employee/leaves";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/hr/{leaveRequestId}/approve")
    public String showRespondToLeaveRequestForm(@PathVariable("leaveRequestId") int leaveRequestId, Model model) {
        model.addAttribute("leaveRequestId", leaveRequestId);
        return "leaveResponse";
    }

    @PostMapping("/hr/{leaveRequestId}/approve")
    public String respondToLeaveRequest(@PathVariable("leaveRequestId") int leaveRequestId, @RequestParam("approvalStatus") ApprovalStatus approvalStatus) {
        leaveService.respondToLeaveRequest(leaveRequestId, approvalStatus);
        return "redirect:/hr/leaves";
    }
}
