package com.hms.service;

import com.hms.model.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private List<Doctor> doctors;
    private int doctorCounter;

    public DoctorService() {
        this.doctors = new ArrayList<>();
        this.doctorCounter = 1;
        // Add some sample data for testing
        addSampleDoctors();
    }

    private void addSampleDoctors() {
        doctors.add(new Doctor("D" + doctorCounter++, "Dr. Sarah Miller", "sarah@hospital.com", "4444444444", "101 Park Ave", "Cardiology", "MD, FACC", 12));
        doctors.add(new Doctor("D" + doctorCounter++, "Dr. Michael Brown", "michael@hospital.com", "5555555555", "202 Oak St", "Pediatrics", "MD, FAAP", 8));
        doctors.add(new Doctor("D" + doctorCounter++, "Dr. Emily Chen", "emily@hospital.com", "6666666666", "303 Pine St", "Orthopedics", "MD, PhD", 15));
    }

    // Add a new doctor
    public void addDoctor(String name, String email, String phone, String address, String specialization, String qualifications, int experience) {
        String doctorId = "D" + doctorCounter++;
        Doctor doctor = new Doctor(doctorId, name, email, phone, address, specialization, qualifications, experience);
        doctors.add(doctor);
        System.out.println("Doctor added successfully! ID: " + doctorId);
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    // Find doctor by ID
    public Doctor findDoctorById(String doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(doctorId)) {
                return doctor;
            }
        }
        return null; // Not found
    }

    // Get doctors by specialization
    public List<Doctor> findDoctorsBySpecialization(String specialization) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialization().equalsIgnoreCase(specialization)) {
                result.add(doctor);
            }
        }
        return result;
    }

    // Get doctor count
    public int getDoctorCount() {
        return doctors.size();
    }
}