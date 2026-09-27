package models;

import exceptions.InvalidNameException;
import exceptions.InvalidPhoneException;

public abstract class User {
    protected int id;
    protected String name;

    private String phone;
    private String city;

    public User(int id,String name,String phone,String city) throws InvalidNameException, InvalidPhoneException {
        this.id = id;
        this.name = validateName(name);
        this.phone = validatePhone(phone);
        this.city = city;
    }

    private static String validateName(String name) throws InvalidNameException {
        if (name == null || !name.matches("[a-zA-Z ]+")) {
            throw new InvalidNameException("Name must contain only alphabets.");
        }
        return name;
    }

    private static String validatePhone(String phone)throws InvalidPhoneException {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new InvalidPhoneException("Phone number must contain exactly 10 digits.");
        }
        return phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidNameException {
        this.name = validateName(name);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone)throws InvalidPhoneException {
        this.phone = validatePhone(phone);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public abstract void displayDetails();
}