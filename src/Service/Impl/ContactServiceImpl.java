package Service.Impl;

import DataBase.DataBase;
import Model.Contact;
import Model.Phone;
import Service.ContactService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactServiceImpl implements ContactService {
    private DataBase dataBase;

    public ContactServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addContactToPhone(int phoneId, Contact contact) {
        Phone phone = dataBase.getPhones().stream().filter(Phone -> Phone.getIdPhone() == phoneId).findFirst().orElse(null);
        if (phone == null) {
            return "phone not found";
        }
        phone.getContacts().add(contact);
        return "Contact added successfully";
    }

    @Override
    public Contact findContactByName(int phoneId, String contactName) {
        Phone phone = dataBase.getPhones().stream().filter(Phone -> Phone.getIdPhone() == phoneId).findFirst().orElse(null);
        if (phone == null) {
            System.out.println("phone not found");
            return null;
        }
        return phone.getContacts().stream().filter(contact1 -> contact1.getNameContact().equalsIgnoreCase(contactName)).findFirst().orElse(null);
    }

    @Override
    public List<Contact> sortContactsByName(int phoneId) {
        Phone phone = dataBase.getPhones().stream().filter(p -> p.getIdPhone() == phoneId).findFirst().orElse(null);
        if (phone == null) {
            return new ArrayList<>();
        }
        return phone.getContacts().stream().sorted(Comparator.comparing(Contact::getNameContact)).toList();
    }

    @Override
    public void deleteContactByNameFromPhone(int phoneId, String contactName) {
        Phone phone = dataBase.getPhones().stream().filter(Phone -> Phone.getIdPhone() == phoneId).findFirst().orElse(null);
        if (phone == null) {
            System.out.println("phone not found");
            return;
        }
        Contact contact = phone.getContacts().stream().filter(contact1 -> contact1.getNameContact().equalsIgnoreCase(contactName)).findFirst().orElse(null);
        if (contact == null) {
            System.out.println("contact not found");
            return;
        }
        phone.getContacts().remove(contact);
        System.out.println("contact deleted");
    }
}
