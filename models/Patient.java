package models;

import interfaces.Searchable;
import exceptions.InvalidNameException;
import exceptions.InvalidPhoneException;

public class Patient extends User implements Searchable {
    private String bloodGroupNeeded;
    
    public Patient(int id,String name,String phone,String city,String bloodGroupNeeded) throws InvalidNameException, InvalidPhoneException {
        super(id,name,phone,city);
        this.bloodGroupNeeded = bloodGroupNeeded;
    }

    public String getBloodGroupNeeded() {
        return bloodGroupNeeded;
    }

    public void setBloodGroupNeeded(String bloodGroupNeeded) {
        this.bloodGroupNeeded = bloodGroupNeeded;
    }

    @Override
    public boolean matchesCity(String city) {
        if (city == null) {
            return false;
        }
        return getCity().equalsIgnoreCase(city.trim());
    }

    @Override
    public boolean matchesKeyword(String keyword) {
        if (keyword == null) {
            return false;
        }
        String search =keyword.trim().toLowerCase();
        return getName().toLowerCase().contains(search) || bloodGroupNeeded.toLowerCase().equals(search) || getCity().toLowerCase().contains(search);
    }

    @Override
    public void displayDetails() {
        System.out.println("Patient ID         : " + id);
        System.out.println("Name               : " + name);
        System.out.println("Phone              : " + getPhone());
        System.out.println("City               : " + getCity());
        System.out.println("Blood Group Needed : " + bloodGroupNeeded);
    }
}