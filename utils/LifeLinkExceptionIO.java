package utils;

import exceptions.BloodGroupNotFoundException;
import exceptions.DonorNotAvailableException;
import exceptions.InsufficientBloodException;
import io.LifeLinkFileManager;
import models.Donor;

public class LifeLinkExceptionIO {
        public static void validateBloodGroup(String bloodGroup) throws BloodGroupNotFoundException {
                String[] validGroups = {
                        "A+",
                        "A-",
                        "B+",
                        "B-",
                        "AB+",
                        "AB-",
                        "O+",
                        "O-"
                };

                if (bloodGroup == null || bloodGroup.isBlank()) {
                throw new BloodGroupNotFoundException("Blood group cannot be empty.");
                }

                String input = bloodGroup.strip().toUpperCase();

                for (String group : validGroups) {
                        if (group.equals(input)) {
                                return;
                        }
                }

                throw new BloodGroupNotFoundException("Invalid blood group: " + bloodGroup);
        }

        public static void checkBloodAvailability(int available,int requested) throws InsufficientBloodException {
                if (requested <= 0) {
                        throw new IllegalArgumentException("Requested units must be greater than zero.");
                }
                if (available < requested) {
                        throw new InsufficientBloodException("Insufficient blood stock. "+ "Only " + available + " units are available, but " 
                        + requested + " units were requested.");
                }
        }

        public static void checkDonorAvailability(Donor donor) throws DonorNotAvailableException {
                if (donor == null) {
                        throw new DonorNotAvailableException("Donor does not exist.");
                }

                if (!donor.isAvailable()) {
                        throw new DonorNotAvailableException("Donor "+ donor.getName()+ " is currently unavailable.");
                }
        }
        
        public static void runDemo() {
                System.out.println();
                System.out.println("==========================================");
                System.out.println("       LIFELINK EXCEPTION & I/O"           );
                System.out.println("==========================================");
                System.out.println();
                System.out.println("1. Blood Group Validation");

                try {
                        validateBloodGroup("X+");
                        System.out.println("Blood group is valid.");
                } 
                catch ( BloodGroupNotFoundException e) {
                        System.out.println("Error: "+ e.getMessage());
                }
                
                System.out.println();
                System.out.println("2. Blood Inventory Check");
                int availableUnits = 5;
                int requestedUnits = 8;

                try {
                        checkBloodAvailability(availableUnits,requestedUnits);
                        System.out.println("Blood request can be fulfilled.");
                } 
                catch ( InsufficientBloodException e) {
                        System.out.println("❌ Blood request cannot be fulfilled.");
                        System.out.println(e.getMessage());
                }
                
                System.out.println();
                System.out.println("3. Donor Availability Check");

                try {
                        Donor donor = new Donor(1,"Demo Donor","9999999999","Tiruppur","O+");
                        donor.setAvailable(false);
                        checkDonorAvailability(donor);
                        System.out.println("Donor is available.");
                } 
                catch (DonorNotAvailableException e) {
                        System.out.println("❌ Donor unavailable.");
                        System.out.println(e.getMessage());
                } 
                catch (Exception e) {
                        System.out.println("Donor test error: "+ e.getMessage());
                }

                System.out.println();
                System.out.println("4. Character Stream File I/O");

                String fileName = "lifelink_data.txt";
                String data = "LifeLink Blood Donation System\n" + "Blood Group: O+\n" + "Available Units: 5\n";

                LifeLinkFileManager.writeFile(fileName,data);

                String fileContent = LifeLinkFileManager.readFile(fileName);

                System.out.println();
                System.out.println("File Content:");
                System.out.println(fileContent);

                LifeLinkFileManager.appendFile(fileName,"Status: ACTIVE");

                System.out.println();
                System.out.println("5. StringBuilder");

                StringBuilder report =new StringBuilder();

                report.append("LifeLink Blood Report\n");
                report.append("---------------------\n");
                report.append("Blood Group: O+\n");
                report.append("Units Available: 5\n");

                System.out.println(report);
                System.out.println("6. StringBuffer");
                
                StringBuffer notification = new StringBuffer();

                notification.append("Emergency Blood Request");
                notification.append(" - O+ Required");

                System.out.println(notification);
                System.out.println();
                System.out.println("7. Modern String Methods");

                String text ="   LifeLink Blood Donation   ";

                System.out.println("Original: [" + text + "]");
                System.out.println("Cleaned: ["+ Java21StringUtils.cleanText(text)+ "]");
                System.out.println("Is Blank: "+ Java21StringUtils.isBlank(text));
                System.out.println("Repeated: "+ Java21StringUtils.repeatMessage("🩸 ",3));
                System.out.println();
                System.out.println("==========================================");
                System.out.println("       UNIT 3 DEMO COMPLETED              ");
                System.out.println("==========================================");
        }
}