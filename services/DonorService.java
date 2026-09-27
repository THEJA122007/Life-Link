package services;

import java.util.ArrayList;
import models.Donor;

public class DonorService {
        private ArrayList<Donor> donors;

        public DonorService() {
                donors = new ArrayList<>();
        }

        public void addDonor(Donor donor) {
                donors.add(donor);
                System.out.println("Donor registered successfully!");
        }

        public void viewAllDonors() {
                if (donors.isEmpty()) {
                        System.out.println("No donors registered.");
                        return;
                }
                
                System.out.println("\n===== ALL DONORS =====");

                for (Donor donor : donors) {
                        donor.displayDetails();
                        System.out.println("----------------------");
                }
        }

        public ArrayList<Donor> findMatchingDonors(String bloodGroup,String city) {
                ArrayList<Donor> matches = new ArrayList<>();
                for (Donor donor : donors) {
                        boolean sameBloodGroup = donor.getBloodGroup().equalsIgnoreCase(bloodGroup);
                        boolean sameCity = donor.getCity().equalsIgnoreCase(city);
                        if (sameBloodGroup && sameCity && donor.isAvailable()) {
                                matches.add(donor);
                        }
                }
                return matches;
        }

        public boolean updateAvailability(int donorId,boolean available) {
                for (Donor donor : donors) {
                        if (donor.getId()== donorId) {
                                donor.setAvailable(available);
                                return true;
                        }
                }
                return false;
        }
}