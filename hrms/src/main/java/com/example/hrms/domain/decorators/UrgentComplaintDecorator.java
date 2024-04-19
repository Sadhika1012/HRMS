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

    public void escalate() {
        // Check if the complaint description contains the word "internet"
        if (getComplaintText().toLowerCase().contains("internet")) {
            // If it contains "internet", set status to "High Priority"
            setStatus(Status.HIGH_PRIORITY);
        } else {
            // If not, set status to "Open"
            setStatus(Status.OPEN);
        }
    }
    

    // Method to get the underlying Complaint object
    public Complaint getComplaint() {
        return complaint;
    }
}
