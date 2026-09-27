package services;

import java.util.ArrayList;
import models.Patient;

public class PatientService {
    private ArrayList<Patient> patients;

    public PatientService() {
        patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient registered successfully!");
    }

    public void viewAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }

        System.out.println("\n===== ALL PATIENTS =====");

        for (Patient patient : patients) {
            patient.displayDetails();
            System.out.println("----------------------");
        }
    }
}
