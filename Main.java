import java.util.ArrayList;
import java.util.Scanner;
import exceptions.InvalidNameException;
import exceptions.InvalidPhoneException;
import models.BloodRequest;
import models.Donor;
import models.Hospital;
import models.Patient;
import services.BloodRequestService;
import services.DonorService;
import services.HospitalService;
import services.InventoryService;
import services.PatientService;
import services.UserRegistry;
import utils.LifeLinkUtils;
import utils.LifeLinkExceptionIO;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DonorService donorService = new DonorService();
    private static final PatientService patientService = new PatientService();
    private static final HospitalService hospitalService = new HospitalService();
    private static final BloodRequestService bloodRequestService = new BloodRequestService();
    private static final InventoryService inventoryService = new InventoryService();
    private static final UserRegistry userRegistry = new UserRegistry();

    private static int donorIdCounter = 1;
    private static int patientIdCounter = 1;
    private static int hospitalIdCounter = 1;
    private static int requestIdCounter = 1;

    public static void main(String[] args) {
        boolean running = true;
        System.out.println();
        System.out.println("========================================");
        System.out.println("   LIFELINK BLOOD DONATION SYSTEM");
        System.out.println("========================================");

        while (running) {
            showMenu();
            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    registerDonor();
                    break;
                case 2:
                    registerPatient();
                    break;
                case 3:
                    registerHospital();
                    break;
                case 4:
                    viewAllDonors();
                    break;
                case 5:
                    viewAllPatients();
                    break;
                case 6:
                    viewAllHospitals();
                    break;
                case 7:
                    createBloodRequest();
                    break;
                case 8:
                    findMatchingDonors();
                    break;
                case 9:
                    updateDonorAvailability();
                    break;
                case 10:
                    addBloodInventory();
                    break;
                case 11:
                    viewBloodInventory();
                    break;
                case 12:
                    viewAllBloodRequests();
                    break;
                case 13:
                    LifeLinkExceptionIO.runDemo();
                    break;
                case 14:
                    running = false;
                    System.out.println();
                    System.out.println("Thank you for using LifeLink!");
                    System.out.println("Together we can save lives.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("============= LIFELINK MENU =============");
        System.out.println("1. Register Donor");
        System.out.println("2. Register Patient");
        System.out.println("3. Register Hospital");
        System.out.println("4. View All Donors");
        System.out.println("5. View All Patients");
        System.out.println("6. View All Hospitals");
        System.out.println("7. Create Blood Request");
        System.out.println("8. Find Matching Donors");
        System.out.println("9. Update Donor Availability");
        System.out.println("10. Add Blood Inventory");
        System.out.println("11. View Blood Inventory");
        System.out.println("12. View All Blood Requests");
        System.out.println("13. Exception Handling & File I/O");
        System.out.println("14. Exit");
        System.out.println("=========================================");
    }

    private static void registerDonor() {
        System.out.println();
        System.out.println("----- REGISTER DONOR -----");
        System.out.print("Enter donor name: ");

        String name = scanner.nextLine().trim();

        System.out.print("Enter phone number: ");
        
        String phone = scanner.nextLine().trim();

        if (userRegistry.isPhoneRegistered(phone)) {
            System.out.println("Phone number already registered!");
            return;
        }

        System.out.print("Enter city: ");

        String city = scanner.nextLine().trim();
        String bloodGroup = getValidBloodGroup();

        try {
            Donor donor = new Donor(donorIdCounter,name,phone,city,bloodGroup);
            donorService.addDonor(donor);
            userRegistry.registerPhone(phone);

            System.out.println("Donor registered successfully!");
            System.out.println("Donor ID: " + donorIdCounter);

            donorIdCounter++;
        }
        catch (InvalidNameException | InvalidPhoneException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }

    private static void registerPatient() {
        System.out.println();
        System.out.println("----- REGISTER PATIENT -----");
        System.out.print("Enter patient name: ");

        String name = scanner.nextLine().trim();

        System.out.print("Enter phone number: ");

        String phone = scanner.nextLine().trim();

        if (userRegistry.isPhoneRegistered(phone)) {
            System.out.println("Phone number already registered!");
            return;
        }

        System.out.print("Enter city: ");


        String city = scanner.nextLine().trim();
        String bloodGroupNeeded = getValidBloodGroup();

        try {
            Patient patient = new Patient(patientIdCounter,name,phone,city,bloodGroupNeeded);
            
            patientService.addPatient(patient);
            userRegistry.registerPhone(phone);

            System.out.println("Patient registered successfully!");
            System.out.println("Patient ID: " + patientIdCounter);

            patientIdCounter++;
        } 
        catch (InvalidNameException | InvalidPhoneException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }

    private static void registerHospital() {
        System.out.println();
        System.out.println("----- REGISTER HOSPITAL -----");
        System.out.print("Enter contact person name: ");

        String contactPerson = scanner.nextLine().trim();

        System.out.print("Enter phone number: ");

        String phone = scanner.nextLine().trim();

        if (userRegistry.isPhoneRegistered(phone)) {
            System.out.println("Phone number already registered!");
            return;
        }

        System.out.print("Enter city: ");

        String city = scanner.nextLine().trim();

        System.out.print("Enter hospital name: ");

        String hospitalName = scanner.nextLine().trim();

        try {
            Hospital hospital = new Hospital(hospitalIdCounter,contactPerson,phone,city,hospitalName);

            hospitalService.addHospital(hospital);
            userRegistry.registerPhone(phone);

            System.out.println("Hospital registered successfully!");
            System.out.println("Hospital ID: " + hospitalIdCounter);

            hospitalIdCounter++;
        } 
        catch (InvalidNameException | InvalidPhoneException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }

    private static void viewAllDonors() {
        System.out.println();
        donorService.viewAllDonors();
    }

    private static void viewAllPatients() {
        System.out.println();
        patientService.viewAllPatients();
    }

    private static void viewAllHospitals() {
        System.out.println();
        hospitalService.viewAllHospitals();
    }

    private static void createBloodRequest() {
        System.out.println();
        System.out.println("----- CREATE BLOOD REQUEST -----");
        System.out.print("Enter patient name: ");

        String patientName = scanner.nextLine().trim();
        String bloodGroup = getValidBloodGroup();

        int unitsRequired = getPositiveInt("Enter units required: ");

        System.out.print("Enter city: ");

        String city = scanner.nextLine().trim();
        String urgency = getUrgencyLevel();

        BloodRequest request = new BloodRequest(requestIdCounter,patientName,bloodGroup,unitsRequired,city,urgency);

        bloodRequestService.createRequest(request);

        System.out.println("Blood request created successfully!");
        System.out.println("Request ID: " + requestIdCounter);

        requestIdCounter++;

        ArrayList<Donor> matches = donorService.findMatchingDonors(bloodGroup,city);

        displayMatchingDonors(matches);
    }

    private static void findMatchingDonors() {
        System.out.println();
        System.out.println("----- FIND MATCHING DONORS -----");

        String bloodGroup = getValidBloodGroup();

        System.out.print("Enter city: ");

        String city = scanner.nextLine().trim();

        ArrayList<Donor> matches = donorService.findMatchingDonors(bloodGroup,city);

        displayMatchingDonors(matches);
    }

    private static void displayMatchingDonors(ArrayList<Donor> matches) {
        if (matches.isEmpty()) {
            System.out.println();
            System.out.println("No matching donors found.");
            return;
        }

        System.out.println();
        System.out.println("===== MATCHING DONORS =====");

        for (Donor donor : matches) {
            donor.displayDetails();
            System.out.println("---------------------------");
        }
    }

    private static void updateDonorAvailability() {
        System.out.println();
        System.out.println("----- UPDATE DONOR AVAILABILITY -----");

        int donorId = getPositiveInt("Enter Donor ID: ");

        System.out.println("1. Available");
        System.out.println("2. Not Available");

        int choice;

        while (true) {
            choice = getIntInput("Enter choice: ");

            if (choice == 1 || choice == 2) {
                break;
            }

            System.out.println("Invalid choice! Enter 1 or 2.");
        }

        boolean available = choice == 1;
        boolean updated = donorService.updateAvailability(donorId,available);

        if (updated) {
            System.out.println("Donor availability updated successfully!");
        } 
        else {
            System.out.println("Donor ID not found!");
        }
    }

    private static void addBloodInventory() {

        System.out.println();
        System.out.println("----- ADD BLOOD INVENTORY -----");

        String bloodGroup = getValidBloodGroup();

        int units =getPositiveInt("Enter number of units: ");

        inventoryService.addBlood(bloodGroup,units);

        System.out.println( "Blood inventory updated successfully!");
    }

    private static void viewBloodInventory() {
        System.out.println();
        inventoryService.viewInventory();
    }

    private static void viewAllBloodRequests() {
        System.out.println();
        bloodRequestService.viewAllRequests();
    }

    private static String getValidBloodGroup() {
        while (true) {
            System.out.println();
            System.out.println("Available Blood Groups:");

            for (String group :LifeLinkUtils.BLOOD_GROUPS) {
                System.out.print(group + " ");
            }

            System.out.println();
            System.out.print("Enter blood group: ");

            String bloodGroup = scanner.nextLine().trim().toUpperCase();

            if (LifeLinkUtils.isValidBloodGroup(bloodGroup)) {
                return bloodGroup;
            }

            System.out.println("Invalid blood group! Try again.");
        }
    }

    private static String getUrgencyLevel() {
        System.out.println();
        System.out.println("Select Urgency Level:");
        System.out.println("1. LOW");
        System.out.println("2. MEDIUM");
        System.out.println("3. HIGH");
        System.out.println("4. EMERGENCY");

        while (true) {
            int choice =getIntInput("Enter urgency choice: ");

            switch (choice) {
                case 1:
                    return "LOW";
                case 2:
                    return "MEDIUM";
                case 3:
                    return "HIGH";
                case 4:
                    return "EMERGENCY";
                default:
                    System.out.println("Invalid urgency choice!");
            }
        }
    }

    private static int getIntInput(String message) {
        while (true) {
            try {
                System.out.print(message);

                String input =scanner.nextLine();

                return Integer.parseInt(input.trim());
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a valid number.");
            }
        }
    }

    private static int getPositiveInt(String message) {
        while (true) {
            int number = getIntInput(message);
            if (number > 0) {
                return number;
            }
            System.out.println("Please enter a number greater than 0.");
        }
    }
}