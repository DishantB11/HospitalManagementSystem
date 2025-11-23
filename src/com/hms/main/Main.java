package com.hms.main;

import com.hms.service.PatientService;
import com.hms.service.DoctorService;
import com.hms.service.AppointmentService;
import com.hms.model.Patient;
import com.hms.model.Doctor;
import com.hms.model.Appointment;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static PatientService patientService;
    private static DoctorService doctorService;
    private static AppointmentService appointmentService;
    private static Scanner scanner;

    public static void main(String[] args) {
        initializeServices();
        scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Hospital Management System ===");

        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    managePatients();
                    break;
                case 2:
                    manageDoctors();
                    break;
                case 3:
                    manageAppointments();
                    break;
                case 4:
                    viewSystemSummary();
                    break;
                case 0:
                    System.out.println("Thank you for using HMS. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    private static void initializeServices() {
        patientService = new PatientService();
        doctorService = new DoctorService();
        appointmentService = new AppointmentService(patientService, doctorService);
    }

    private static void displayMainMenu() {
        System.out.println("\n===== MAIN MENU =====");
        System.out.println("1. Patient Management");
        System.out.println("2. Doctor Management");
        System.out.println("3. Appointment Management");
        System.out.println("4. System Summary");
        System.out.println("0. Exit");
        System.out.println("=====================");
    }

    private static void managePatients() {
        System.out.println("\n--- Patient Management ---");
        System.out.println("1. Add New Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Back to Main Menu");

        int choice = getIntInput("Enter choice: ");
        switch (choice) {
            case 1:
                addNewPatient();
                break;
            case 2:
                viewAllPatients();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void addNewPatient() {
        System.out.println("\n--- Add New Patient ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dob = scanner.nextLine();
        System.out.print("Enter blood group: ");
        String bloodGroup = scanner.nextLine();

        patientService.addPatient(name, email, phone, address, dob, bloodGroup);
    }

    private static void viewAllPatients() {
        System.out.println("\n--- All Patients ---");
        List<Patient> patients = patientService.getAllPatients();
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            for (Patient patient : patients) {
                System.out.println("ID: " + patient.getId() + " | Name: " + patient.getName() +
                        " | Email: " + patient.getEmail() + " | Phone: " + patient.getPhoneNumber());
            }
        }
    }

    private static void manageDoctors() {
        System.out.println("\n--- Doctor Management ---");
        System.out.println("1. View All Doctors");
        System.out.println("2. Find Doctors by Specialization");
        System.out.println("3. Back to Main Menu");

        int choice = getIntInput("Enter choice: ");
        switch (choice) {
            case 1:
                viewAllDoctors();
                break;
            case 2:
                findDoctorsBySpecialization();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void viewAllDoctors() {
        System.out.println("\n--- All Doctors ---");
        List<Doctor> doctors = doctorService.getAllDoctors();
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println("ID: " + doctor.getId() + " | Name: " + doctor.getName() +
                        " | Specialization: " + doctor.getSpecialization() +
                        " | Experience: " + doctor.getYearsOfExperience() + " years");
            }
        }
    }

    private static void findDoctorsBySpecialization() {
        System.out.print("\nEnter specialization to search: ");
        String specialization = scanner.nextLine();
        List<Doctor> doctors = doctorService.findDoctorsBySpecialization(specialization);

        if (doctors.isEmpty()) {
            System.out.println("No doctors found with specialization: " + specialization);
        } else {
            System.out.println("Doctors in " + specialization + ":");
            for (Doctor doctor : doctors) {
                System.out.println(" - " + doctor.getName() + " (" + doctor.getQualifications() + ")");
            }
        }
    }

    private static void manageAppointments() {
        System.out.println("\n--- Appointment Management ---");
        System.out.println("1. Schedule New Appointment");
        System.out.println("2. View All Appointments");
        System.out.println("3. Cancel Appointment");
        System.out.println("4. Back to Main Menu");

        int choice = getIntInput("Enter choice: ");
        switch (choice) {
            case 1:
                scheduleAppointment();
                break;
            case 2:
                viewAllAppointments();
                break;
            case 3:
                cancelAppointment();
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void scheduleAppointment() {
        System.out.println("\n--- Schedule New Appointment ---");

        // Show available patients
        System.out.println("Available Patients:");
        viewAllPatients();
        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();

        // Show available doctors
        System.out.println("Available Doctors:");
        viewAllDoctors();
        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine();

        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        System.out.print("Enter appointment time (HH:MM): ");
        String timeStr = scanner.nextLine();

        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateStr + "T" + timeStr + ":00");
            appointmentService.scheduleAppointment(patientId, doctorId, dateTime);
        } catch (Exception e) {
            System.out.println("Error: Invalid date/time format. Please use YYYY-MM-DD and HH:MM format.");
        }
    }

    private static void viewAllAppointments() {
        System.out.println("\n--- All Appointments ---");
        List<Appointment> appointments = appointmentService.getAllAppointments();
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            for (Appointment appointment : appointments) {
                Patient patient = patientService.findPatientById(appointment.getPatientId());
                Doctor doctor = doctorService.findDoctorById(appointment.getDoctorId());
                System.out.println("Appointment ID: " + appointment.getAppointmentId() +
                        " | Patient: " + (patient != null ? patient.getName() : "Unknown") +
                        " | Doctor: " + (doctor != null ? doctor.getName() : "Unknown") +
                        " | Date: " + appointment.getAppointmentDateTime() +
                        " | Status: " + appointment.getStatus());
            }
        }
    }

    private static void cancelAppointment() {
        System.out.print("\nEnter Appointment ID to cancel: ");
        String appointmentId = scanner.nextLine();
        appointmentService.cancelAppointment(appointmentId);
    }

    private static void viewSystemSummary() {
        System.out.println("\n--- System Summary ---");
        System.out.println("Total Patients: " + patientService.getPatientCount());
        System.out.println("Total Doctors: " + doctorService.getDoctorCount());
        System.out.println("Total Appointments: " + appointmentService.getAppointmentCount());
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        }
    }
}
