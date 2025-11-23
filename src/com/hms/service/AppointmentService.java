package com.hms.service;

import com.hms.model.Appointment;
import com.hms.model.Patient;
import com.hms.model.Doctor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private List<Appointment> appointments;
    private int appointmentCounter;
    private PatientService patientService;
    private DoctorService doctorService;

    public AppointmentService(PatientService patientService, DoctorService doctorService) {
        this.appointments = new ArrayList<>();
        this.appointmentCounter = 1;
        this.patientService = patientService;
        this.doctorService = doctorService;
        // Add some sample appointments for testing
        addSampleAppointments();
    }

    private void addSampleAppointments() {
        // Make sure we have patients and doctors first
        if (patientService.getPatientCount() > 0 && doctorService.getDoctorCount() > 0) {
            appointments.add(new Appointment("A" + appointmentCounter++, "P1", "D1",
                    LocalDateTime.of(2024, 1, 20, 10, 0)));
            appointments.add(new Appointment("A" + appointmentCounter++, "P2", "D2",
                    LocalDateTime.of(2024, 1, 21, 14, 30)));
        }
    }

    // Schedule a new appointment
    public boolean scheduleAppointment(String patientId, String doctorId, LocalDateTime dateTime) {
        // Check if patient exists
        Patient patient = patientService.findPatientById(patientId);
        if (patient == null) {
            System.out.println("Error: Patient with ID " + patientId + " not found!");
            return false;
        }

        // Check if doctor exists
        Doctor doctor = doctorService.findDoctorById(doctorId);
        if (doctor == null) {
            System.out.println("Error: Doctor with ID " + doctorId + " not found!");
            return false;
        }

        // Create and add appointment
        String appointmentId = "A" + appointmentCounter++;
        Appointment appointment = new Appointment(appointmentId, patientId, doctorId, dateTime);
        appointments.add(appointment);

        System.out.println("Appointment scheduled successfully!");
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient: " + patient.getName());
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Date: " + dateTime);
        return true;
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    // Get appointments by patient ID
    public List<Appointment> getAppointmentsByPatientId(String patientId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getPatientId().equals(patientId)) {
                result.add(appointment);
            }
        }
        return result;
    }

    // Get appointments by doctor ID
    public List<Appointment> getAppointmentsByDoctorId(String doctorId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getDoctorId().equals(doctorId)) {
                result.add(appointment);
            }
        }
        return result;
    }

    // Cancel an appointment
    public boolean cancelAppointment(String appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                appointment.setStatus("CANCELLED");
                System.out.println("Appointment " + appointmentId + " has been cancelled.");
                return true;
            }
        }
        System.out.println("Error: Appointment with ID " + appointmentId + " not found!");
        return false;
    }

    // Get appointment count
    public int getAppointmentCount() {
        return appointments.size();
    }
}