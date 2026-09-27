package utils;

import models.Donor;
import models.User;

public class LifeLinkUtils {
        public static final String[] BLOOD_GROUPS = {
                "A+",
                "A-",
                "B+",
                "B-",
                "AB+",
                "AB-",
                "O+",
                "O-"
        };

        public static boolean isValidBloodGroup(String bloodGroup) {
                for (String group : BLOOD_GROUPS) {
                        if (group.equalsIgnoreCase(bloodGroup)) {
                                return true;
                        }
                }
                return false;
        }

        public static String createDonorReport(Donor donor) {
                StringBuilder report = new StringBuilder();
                
                report.append("========== DONOR REPORT ==========\n");
                report.append("ID: ");
                report.append(donor.getId());
                report.append("\n");
                report.append("Name: ");
                report.append(donor.getName());
                report.append("\n");
                report.append("Blood Group: ");
                report.append(donor.getBloodGroup());
                report.append("\n");
                report.append("City: ");
                report.append(donor.getCity());
                report.append("\n");
                report.append("Available: ");
                report.append(donor.isAvailable());
                report.append("\n");
                report.append("==================================");
                return report.toString();
        }

        public static String createEmergencyMessage(String patientName,String bloodGroup,String city) {
                StringBuffer message = new StringBuffer();

                message.append("!!! EMERGENCY BLOOD REQUEST !!!\n");
                message.append("Patient: ");
                message.append(patientName);
                message.append("\nBlood Group Required: ");
                message.append(bloodGroup);
                message.append("\nLocation: ");
                message.append(city);
                message.append("\nPlease respond immediately.");

                return message.toString();
        }

        public static void displayUsers(User[] users) {
                for (User user : users) {
                        user.displayDetails();
                        System.out.println("---------------------------");
                }
        }
}