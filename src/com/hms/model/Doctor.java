package com.hms.model;

public class Doctor extends User {
    private String specialization;
    private String qualifications;
    private int yearsOfExperience;

    // Constructor
    public Doctor(String id, String name, String email, String phoneNumber, String address, String specialization, String qualifications, int yearsOfExperience) {
        super(id, name, email, phoneNumber, address);
        this.specialization = specialization;
        this.qualifications = qualifications;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Getters and Setters
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}