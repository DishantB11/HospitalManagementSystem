package com.hms.service;

import com.hms.model.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private List<Patient> patients;
    private int patientCounter;

    public PatientService() {
        this.patients = new ArrayList<>();
        this.patientCounter = 1;
        // Add some sample data for testing
        addSamplePatients();
    }

    private void addSamplePatients() {
        patients.add(new Patient("P" + patientCounter++, "Alice Johnson", "alice@email.com", "1111111111", "123 Green St", "1985-03-20", "A+"));
        patients.add(new Patient("P" + patientCounter++, "Bob Wilson", "bob@email.com", "2222222222", "456 Blue St", "1992-07-15", "B-"));
        patients.add(new Patient("P" + patientCounter++, "Carol Davis", "carol@email.com", "3333333333", "789 Red St", "1978-11-30", "O+"));
    }

    // Add a new patient
    public void addPatient(String name, String email, String phone, String address, String dob, String bloodGroup) {
        String patientId = "P" + patientCounter++;
        Patient patient = new Patient(patientId, name, email, phone, address, dob, bloodGroup);
        patients.add(patient);
        System.out.println("Patient added successfully! ID: " + patientId);
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patients;
    }

    // Find patient by ID
    public Patient findPatientById(String patientId) {
        for (Patient patient : patients) {
            if (patient.getId().equals(patientId)) {
                return patient;
            }
        }
        return null; // Not found
    }

    // Update patient information
    public boolean updatePatient(String patientId, String name, String email, String phone, String address) {
        Patient patient = findPatientById(patientId);
        if (patient != null) {
            patient.setName(name);
            patient.setEmail(email);
            patient.setPhoneNumber(phone);
            patient.setAddress(address);
            return true;
        }
        return false;
    }

    // Get patient count
    public int getPatientCount() {
        return patients.size();
    }
}