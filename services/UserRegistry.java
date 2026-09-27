package services;

import java.util.HashSet;

public class UserRegistry {
    private HashSet<String> registeredPhones;

    public UserRegistry() {
        registeredPhones = new HashSet<>();
    }

    public boolean registerPhone(String phone) {
        if (registeredPhones.contains(phone)) {
            return false;
        }

        registeredPhones.add(phone);
        return true;
    }

    public boolean isPhoneRegistered(String phone) {
        return registeredPhones.contains(phone);
    }

    public int getRegisteredUserCount() {
        return registeredPhones.size();
    }

    public void displayRegisteredPhones() {
        if (registeredPhones.isEmpty()) {
            System.out.println("No phone numbers registered.");
            return;
        }

        System.out.println("\n===== REGISTERED PHONE NUMBERS =====");
        
        for (String phone : registeredPhones) {
            System.out.println(phone);
        }
    }
}