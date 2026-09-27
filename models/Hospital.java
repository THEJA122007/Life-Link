package models;

import java.util.HashMap;
import interfaces.InventoryManageable;
import interfaces.Searchable;
import exceptions.InvalidNameException;
import exceptions.InvalidPhoneException;

public class Hospital extends User implements Searchable, InventoryManageable {
    private String hospitalName;
    private HashMap<String, Integer> inventory;
    
    public Hospital(int id,String contactPerson,String phone,String city,String hospitalName) throws InvalidNameException, InvalidPhoneException {
        super(id,contactPerson,phone,city);
        this.hospitalName = hospitalName;
        this.inventory = new HashMap<>();
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) { 
        this.hospitalName = hospitalName;
    }

    @Override
    public void addBlood(String bloodGroup,int units) {
        if (bloodGroup == null || units <= 0) {
            System.out.println("Invalid blood inventory data.");
            return;
        }

        String group = bloodGroup.trim().toUpperCase();
        int currentUnits = inventory.getOrDefault(group,0);

        inventory.put(group,currentUnits + units);

        System.out.println(units + " units of " + group + " added.");
    }

    @Override
    public boolean removeBlood(String bloodGroup,int units) {
        if (bloodGroup == null|| units <= 0) {
            return false;
        }
        String group = bloodGroup.trim().toUpperCase();

        int currentUnits = inventory.getOrDefault( group, 0);

        if (currentUnits < units) {
            return false;
        }
        inventory.put(group,currentUnits - units);
        return true;
    }

    @Override
    public int getBloodUnits(String bloodGroup) {
        if (bloodGroup == null) {
            return 0;
        }
        String group = bloodGroup.trim().toUpperCase();

        return inventory.getOrDefault(group,0);
    }

    @Override
    public boolean matchesCity(String city) {
        if (city == null) {
            return false;
        }
        return getCity()
                .equalsIgnoreCase(city.trim());
    }

    @Override
    public boolean matchesKeyword(String keyword) {
        if (keyword == null) {
            return false;
        }

        String search =keyword.trim().toLowerCase();

        return hospitalName
                .toLowerCase()
                .contains(search)
                || getName()
                .toLowerCase()
                .contains(search)
                || getCity()
                .toLowerCase()
                .contains(search);
    }

    @Override
    public void displayDetails() {
        System.out.println("Hospital ID    : " + id);
        System.out.println("Hospital Name  : " + hospitalName);
        System.out.println("Contact Person : " + name);
        System.out.println("Phone          : " + getPhone());
        System.out.println("City           : " + getCity());
        System.out.println("Blood Inventory: " + inventory);
    }
}