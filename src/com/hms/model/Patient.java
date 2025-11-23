package com.hms.model;

public class Patient extends User {
    private String dateOfBirth;
    private String bloodGroup;
    private String medicalHistory;

    // Constructor
    public Patient(String id, String name, String email, String phoneNumber, String address, String dateOfBirth, String bloodGroup) {
        super(id, name, email, phoneNumber, address); // Call parent constructor
        this.dateOfBirth = dateOfBirth;
        this.bloodGroup = bloodGroup;
        this.medicalHistory = ""; // Initialize as empty
    }

    // Getters and Setters for Patient-specific fields
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}