// AttendanceController.java
package com.example.hrms.controller;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.hrms.domain.Attendance;
import com.example.hrms.model.AddAttendanceRequest;
import com.example.hrms.model.UpdateAttendanceRequest;
import com.example.hrms.service.AttendanceService;
import com.example.hrms.service.command.AddAttendanceCommand;
import com.example.hrms.service.command.UpdateAttendanceCommand;

import jakarta.servlet.http.HttpSession;

@Controller

public class AttendanceController {
    
    private final UpdateAttendanceCommand updateAttendanceCommand;
    private final AddAttendanceCommand addAttendanceCommand;
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService,UpdateAttendanceCommand updateAttendanceCommand, AddAttendanceCommand addAttendanceCommand) {
        this.attendanceService = attendanceService;
        this.updateAttendanceCommand = updateAttendanceCommand;
        this.addAttendanceCommand = addAttendanceCommand;
    }

    @GetMapping("/hr/attendance_view")
public String viewAttendance(Model model) {
    List<Attendance> attendances = attendanceService.getAllAttendance(); // Implement this method in AttendanceService
    model.addAttribute("attendances", attendances);
    return "view-attendance";
}

    @GetMapping("/hr/attendance/{attendanceId}")
    public String showUpdateAttendanceForm(@PathVariable int attendanceId, Model model) {
        UpdateAttendanceRequest request = new UpdateAttendanceRequest();
        request.setAttendanceId(attendanceId);
        model.addAttribute("updateAttendanceRequest", request);
        return "update-attendance-form";
    }

    @PostMapping("/hr/attendance")
    public String updateAttendance(@ModelAttribute("updateAttendanceRequest") UpdateAttendanceRequest request) {
        updateAttendanceCommand.setAttendanceId(request.getAttendanceId());
        updateAttendanceCommand.setCheckOut(request.getCheckOut());
        updateAttendanceCommand.execute();
        return "redirect:/hr/attendance_view";
    }

    @GetMapping("/hr/add_attendance")
    public String showAddAttendanceForm(Model model) {
        model.addAttribute("addAttendanceRequest", new AddAttendanceRequest());
        return "add-attendance-form";
    }

    @PostMapping("/hr/add_attendance")
    public String addAttendance(AddAttendanceRequest request, Model model) {
        try {
            addAttendanceCommand.setEmployeeId(request.getEmployeeId());
            addAttendanceCommand.setCheckIn(request.getCheckIn());
            addAttendanceCommand.execute();
            return "redirect:/hr/attendance_view";
        } catch (DataIntegrityViolationException e) {
            // If it's a foreign key constraint violation, display a custom error message
            if (e.getMessage().contains("foreign key constraint")) {
                model.addAttribute("errorMessage", "Invalid employee ID. Please try again.");
            } else {
                // For other types of data integrity violations, display the default error message
                model.addAttribute("errorMessage", e.getMessage());
            }
            // Return the add-attendance page to display the error message and the form again
            return "add-attendance-form";
        }
    }
    
    @GetMapping("/employee/attendance")
    public String showEmployeeComplaintList(Model model, HttpSession session) {
        // Retrieve the userId from the session
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId != null) {
            // Retrieve the list of queries related to the employee based on their userId
            List<Attendance> attendancess = attendanceService.getAttendanceByEmployeeId(userId);
            model.addAttribute("attendances", attendancess);
        }
        // Return the name of the Thymeleaf template for displaying the query list
        return "view-attendance-emp";
    }
    
}
