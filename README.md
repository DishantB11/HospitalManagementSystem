# Hospital Management System

A comprehensive, console-based hospital management system developed in Java. This project demonstrates core Java features including object-oriented programming, collections framework, exception handling, and modular architecture. The application is built with a clear, package-based structure to ensure separation of concerns and maintainability.

## How to Run

### Prerequisites
- **Java Development Kit (JDK)**: Version 11 or higher
- **Git**: To clone the repository
- **(Optional) IDE**: IntelliJ IDEA (recommended) or Eclipse

### 1. From the Command Line
**Clone the repository:**
```bash
git clone https://github.com/DishantB11/HospitalManagementSystem.git
cd HospitalManagementSystem
```
#### Compile all source files:

- Create a directory for compiled classes: ```mkdir bin```

- Compile (for macOS/Linux): ```javac -d bin $(find src -name "*.java")```
 
- Compile (for Windows): 
```javac -d bin src\com\hms\main\*.java 
javac -d bin 
src\com\hms\main\*.java 
src\com\hms\model\*.java 
src\com\hms\service\*.java
```

**Run the application:**

```
java -cp bin com.hms.main.Main
```
### 2. From IntelliJ IDEA
1. Clone the repository

2. Open IntelliJ IDEA → File → Open → Select HospitalManagementSystem folder

3. Navigate to ```src/com/hms/main/Main.java```

4. Right-click on ```Main.java``` and select Run 'Main.main()'

##  Project Overview

### System Architecture
```
HospitalManagementSystem/
├── src/com/hms/
│   ├── main/
│   │   └── Main.java                 # Application entry point
│   ├── model/                        # Data entities
│   │   ├── User.java                 # Base class (Abstract)
│   │   ├── Patient.java              # Inherits from User
│   │   ├── Doctor.java               # Inherits from User  
│   │   └── Appointment.java          # Links Patient & Doctor
│   ├── service/                      # Business logic layer
│   │   ├── PatientService.java       # Patient operations
│   │   ├── DoctorService.java        # Doctor operations
│   │   └── AppointmentService.java   # Appointment scheduling
│   └── util/                         # Utility classes
```

### Syllabus Topic to Code Mapping

| Syllabus Topic | File/Class/Method Where Demonstrated |
| :--- | :--- |
| **Packages & main class** | Project structure (`com.hms.*`), `Main.main()` |
| **OOP - Inheritance** | `Patient` and `Doctor` extend `User` |
| **OOP - Encapsulation** | All model classes with private fields + public getters/setters |
| **OOP - Polymorphism** | `User` as base type for `Patient` and `Doctor` |
| **Constructors & super** | `Patient` / `Doctor` constructors call `super()` |
| **Arrays & Collections** | `ArrayList` in all Service classes |
| **Loops (for, while)** | `Main.main()` (**while loop**), Service classes (**for-each**) |
| **Decision Structures** | `Main` class switch statements for menu navigation |
| **Exception Handling** | Input validation throughout application |
| **Strings & methods** | String manipulation in Service classes |


## Core Features & Workflow
#### 1.  Application Workflow

```
Main Menu → Select Module → Perform Operations → Return to Main Menu
    │
    ├── Patient Management
    │   ├── Add New Patient
    │   ├── View All Patients
    │   └── Update Patient Info
    │
    ├── Doctor Management  
    │   ├── View All Doctors
    │   ├── Search by Specialization
    │   └── View Doctor Details
    │
    ├── Appointment Management
    │   ├── Schedule Appointment
    │   ├── View All Appointments
    │   └── Cancel Appointment
    │
    └── System Summary
        └── View Statistics
```

#### 2. Feature Matrix

| Module | Features | Status |
| :--- | :--- | :--- |
| **Patient Management** | Add, View, Update |  Implemented |
| **Doctor Management** | View, Search by Specialization |  Implemented |
| **Appointment System** | Schedule, View, Cancel |  Implemented |
| **Reporting** | System Statistics |  Implemented |
| **Data Persistence** | In-memory Collections |  Implemented |

## Application Usage Guide

#### Sample Workflow Commands:

 1. View System Overview

```
=== MAIN MENU ===
Select: 4 (System Summary)
Output: Total Patients: 3, Total Doctors: 3, Total Appointments: 2
```
2. Add New Patient

```
Select: 1 (Patient Management) → 1 (Add New Patient)
Input: 
  Name: John Doe
  Email: john@email.com  
  Phone: 1234567890
  Address: 123 Main St
  DOB: 1990-01-01
  Blood Group: O+
Output: Patient added successfully! ID: P4
```

3. Schedule Appointment

```
Select: 3 (Appointment Management) → 1 (Schedule Appointment)
Input:
  Patient ID: P1
  Doctor ID: D1  
  Date: 2024-12-25
  Time: 10:00
Output: Appointment scheduled successfully! ID: A3
```

4. View Doctors by Specialization

```
Select: 2 (Doctor Management) → 2 (Find by Specialization)
Input: Cardiology
Output: Dr. Sarah Miller (MD, FACC) - 12 years experience
```

## Testing Instructions
### Functional Testing Checklist:

- **Main Menu Navigation** - All options accessible
- **Patient Registration** - Add and verify new patients
- **Doctor Management** - View and search doctors
- **Appointment Scheduling** - Book and confirm appointments
- **Data Integrity** - Verify relationships between entities
- **Error Handling** - Test invalid inputs and edge cases

### Sample Test Data
The application includes sample data:

- **3 Patients**: Alice Johnson, Bob Wilson, Carol Davis
- **3 Doctors**: Dr. Sarah Miller (Cardiology), Dr. Michael Brown (Pediatrics), Dr. Emily Chen (Orthopedics)
- **2 Sample Appointments**: Pre-scheduled for testing

### Functional Testing

1. **Main Menu Navigation**
- Run the application
- Verify all menu options display correctly:
```
==== MAIN MENU ====
1. Patient Management
2. Doctor Management  
3. Appointment Management
4. System Summary
0. Exit
===================
```
- Test navigation between different menu sections

2. **Patient Management Test**
- Select Option 1 (Patient Management)
- Choose Option 1 (Add New Patient)
- Enter patient details:
```
Name: John Doe
Email: john@email.com
Phone: 1234567890
Address: 123 Main Street
Date of Birth: 1990-01-01
Blood Group: O+
```
- Verify success message appears: "Patient added successfully!"
- Choose Option 2 (View All Patients) to verify patient was added

3. **Doctor Management Test**
- Select Option 2 (Doctor Management)
- Choose Option 1 (View All Doctors)
- Verify sample doctors display with their specializations
- Choose Option 2 (Find Doctors by Specialization) and search for "Cardiology"

4. **Appointment Scheduling Test**
- Select Option 3 (Appointment Management)
- Choose Option 1 (Schedule New Appointment)
- Use Patient ID: P1
- Use Doctor ID: D1
- Date: 2024-12-25
- Time: 10:00
- Verify appointment confirmation message: "Appointment scheduled successfully!"

5. **System Summary Test**
- Select Option 4 (System Summary)
- Verify counts for patients, doctors, and appointments display 

## Technical Implementation
#### Design Patterns Used:

| Pattern | Implementation | Purpose |
| :--- | :--- | :--- |
| **Layered Architecture** | Model-Service-Main packages | Separation of concerns |
| **Service Layer** | PatientService, DoctorService, AppointmentService | Business logic encapsulation |
| **Inheritance Hierarchy** | User ← Patient/Doctor | Code reuse & polymorphism |

#### Key Java Features Demonstrated:

- **Collections Framework**: ArrayList for data storage
- **OOP Principles**: Inheritance, Encapsulation, Polymorphism
- **Exception Handling**: Input validation throughout
- **Package Organization**: Modular code structure
- **Console I/O**: Scanner for user interaction

## Sample Commands Reference

| Action | Menu Path | Expected Output |
| :--- | :--- | :--- |
| **View all patients** | `1 → 2` | List of all registered patients |
| **Find cardiologists** | `2 → 2 → "Cardiology"` | Doctors specializing in cardiology |
| **Schedule appointment** | `3 → 1 → P1 → D1 → 2024-12-25 → 10:00` | Appointment confirmation |
| **System statistics** | `4` | Counts of patients, doctors, appointments |

## Future Enhancements

- **Database Integration** - Persistent storage with MySQL/PostgreSQL
- **Web Interface** - Spring Boot web application
- **User Authentication** - Login system for different roles
- **Email Notifications** - Appointment reminders
- **Reporting Module** - Advanced analytics and charts
- **REST API** - For mobile app integration


