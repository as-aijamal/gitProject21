package Model;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    private int idPhone;
    private String namePhone;
    private String brand;
    private List<Contact> contacts = new ArrayList<>();

    public Phone(String brand, List<Contact> contacts, int idPhone, String namePhone) {
        this.brand = brand;
        this.contacts = contacts;
        this.idPhone = idPhone;
        this.namePhone = namePhone;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public int getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(int idPhone) {
        this.idPhone = idPhone;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", idPhone=" + idPhone +
                ", namePhone='" + namePhone + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
