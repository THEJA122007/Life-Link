package models;

import interfaces.Donatable;
import interfaces.Searchable;
import exceptions.DonorNotAvailableException;
import exceptions.InvalidNameException;
import exceptions.InvalidPhoneException;

public class Donor extends User implements Donatable, Searchable {
    private String bloodGroup;
    private boolean available;
    private String lastDonationDate;

    public Donor(int id,String name,String phone,String city,String bloodGroup) throws InvalidNameException, InvalidPhoneException {
        super(id,name,phone,city);
        this.bloodGroup = bloodGroup;
        this.available = true;
        this.lastDonationDate = "Not donated yet";
    }
    
    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
        
    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(String lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }

    @Override
    public void donateBlood(String donationDate) throws DonorNotAvailableException {
        if (!available) {
            throw new DonorNotAvailableException("Donor " + getName() + " is currently unavailable.");
        }
        lastDonationDate = donationDate;
        available = false;
        System.out.println( getName()+ " donated blood on "+ donationDate);
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

        String search = keyword.trim().toLowerCase();

        return getName().toLowerCase().contains(search)
               || bloodGroup.toLowerCase().equals(search)
               || getPhone().toLowerCase().contains(search)
               || getCity().toLowerCase().contains(search);
    }

    @Override
    public void displayDetails() {
        System.out.println("Donor ID       : " + getId());
        System.out.println("Name           : " + getName());
        System.out.println("Phone          : " + getPhone());
        System.out.println("City           : " + getCity());
        System.out.println("Blood Group    : " + bloodGroup);
        System.out.println("Available      : " + available);
        System.out.println("Last Donation  : "+ lastDonationDate);
    }
}