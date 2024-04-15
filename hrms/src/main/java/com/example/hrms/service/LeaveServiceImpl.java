package com.example.hrms.service;

import com.example.hrms.domain.LeaveRequest;
import com.example.hrms.domain.ApprovalStatus;
import com.example.hrms.repository.LeaveRequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private  LeaveRequestRepository leaveRequestRepository;

    

    @Override
    public LeaveRequest postLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    @Override
    public LeaveRequest respondToLeaveRequest(int leaveRequestId, ApprovalStatus approvalStatus) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(leaveRequestId)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));
        leaveRequest.setApprovalStatus(approvalStatus);
        return leaveRequestRepository.save(leaveRequest);
    }
    
    @Override
    public List<LeaveRequest> getAllRequests() {
        return leaveRequestRepository.findAll();
    }

    @Override
    public List<LeaveRequest> getRequestsByEmployeeId(int employeeId) {
        return leaveRequestRepository.findByEmployeeId(employeeId);
    }
}
