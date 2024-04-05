package com.example.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.domain.Complaint;
import com.example.hrms.domain.Status;
import com.example.hrms.repository.ComplaintRepository;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Override
    public Complaint postComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public Complaint respondToComplaint(int complaintId, String resolution) {
        Complaint complaint = complaintRepository.findById(complaintId).orElseThrow(() -> new RuntimeException("Complaint not found"));
        complaint.setResolution(resolution);
        complaint.setStatus(Status.CLOSED);
        return complaintRepository.save(complaint);
    }
    
    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public List<Complaint> getComplaintsByEmployeeId(int employeeId) {
        return complaintRepository.findByEmployeeId(employeeId);
    }
    
}

