package Service.Impl;

import DataBase.DataBase;
import Model.Phone;
import Service.PhoneService;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {
    private DataBase dataBase;

    public PhoneServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }
    @Override
    public Phone getPhoneById(int phoneId) {
        return dataBase.getPhones().stream().filter(phone -> phone.getIdPhone() == phoneId).findFirst().orElse(null);
    }

    @Override
    public Phone updatePhoneNameById(int phoneId, String newName) {
        Phone phone = dataBase.getPhones().stream().filter(phone1 -> phone1.getIdPhone() == phoneId).findFirst().orElse(null);
        if (phone == null) {
            System.out.println("phone not found");
            return null;
        }
        phone.setNamePhone(newName);
        return phone;
    }

    @Override
    public List<Phone> getAllPhones() {
        return dataBase.getPhones();
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        return dataBase.getPhones().stream().filter(phone -> phone.getBrand().equalsIgnoreCase(brand)).toList();
    }

    @Override
    public void deletePhoneById(int phoneId) {
        boolean removed = dataBase.getPhones().removeIf(phone -> phone.getIdPhone() == phoneId);
        if (removed) {
            System.out.println("phone deleted successfully");
        } else {
            System.out.println("phone not found");
        }

    }
}
