package Model;

public class Contact {
    private String nameContact;
    private long phoneNumber;

    public Contact(String nameContact, long phoneNumber) {
        this.nameContact = nameContact;
        this.phoneNumber = phoneNumber;
    }

    public String getNameContact() {
        return nameContact;
    }

    public void setNameContact(String nameContact) {
        this.nameContact = nameContact;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String
    toString() {
        return "Contact{" +
                "nameContact='" + nameContact + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
