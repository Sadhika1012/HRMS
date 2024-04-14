package com.example.hrms.service;

import com.example.hrms.domain.LeaveRequest;
import com.example.hrms.domain.ApprovalStatus;

import java.util.List;

public interface LeaveService {
    LeaveRequest postLeaveRequest(LeaveRequest leaveRequest);
    LeaveRequest respondToLeaveRequest(int leaveRequestId, ApprovalStatus approvalStatus);
    List<LeaveRequest> getAllRequests();
    List<LeaveRequest> getRequestsByEmployeeId(int employeeId);
}

