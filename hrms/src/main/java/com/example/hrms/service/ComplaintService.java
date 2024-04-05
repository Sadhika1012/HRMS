package com.example.hrms.service;

import com.example.hrms.domain.Complaint;

public interface  ComplaintService {
    Complaint postComplaint(Complaint complaint);
    Complaint respondToComplaint(int complaintId, String resolution);
    Object getAllComplaints();
    Object getComplaintsByEmployeeId(int employeeId);
}
