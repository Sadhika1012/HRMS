package com.example.hrms.domain.decorators;

import com.example.hrms.domain.Complaint;
import com.example.hrms.domain.Status;

public class UrgentComplaintDecorator {
    private Complaint complaint;

    public UrgentComplaintDecorator(Complaint complaint) {
        this.complaint = complaint;
    }

    public int getComplaintId() {
        return complaint.getComplaintId();
    }

    public String getComplaintText() {
        return complaint.getComplaintText();
    }

    public String getResolution() {
        return complaint.getResolution();
    }

    public void setResolution(String resolution) {
        complaint.setResolution(resolution);
    }

    public Status getStatus() {
        return complaint.getStatus();
    }

    public void setStatus(Status status) {
        complaint.setStatus(status);
    }

    // Additional behavior for urgent complaints
    public void escalate() {
        // Implement escalation logic
        // For example, change status to "High Priority"
        setStatus(Status.HIGH_PRIORITY);
    }

    // Method to get the underlying Complaint object
    public Complaint getComplaint() {
        return complaint;
    }
}
