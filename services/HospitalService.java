package services;

import java.util.ArrayList;
import models.Hospital;

public class HospitalService {
    private ArrayList<Hospital> hospitals;

    public HospitalService() {
        hospitals = new ArrayList<>();
    }

    public void addHospital(Hospital hospital) {
        hospitals.add(hospital);
        System.out.println("Hospital registered successfully!");
    }

    public void viewAllHospitals() {
        if (hospitals.isEmpty()) {
            System.out.println("No hospitals registered.");
            return;
        }

        System.out.println("\n===== ALL HOSPITALS =====");

        for (Hospital hospital : hospitals) {
            hospital.displayDetails();
            System.out.println("----------------------");
        }
    }
}