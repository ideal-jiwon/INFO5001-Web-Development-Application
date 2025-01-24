package bank_account;

public class OwnerProfile {

    String name;
    String type;
    Address address;
    ContactInfo contactInfo;

    public OwnerProfile(String name, String type, Address address, ContactInfo contactInfo) {
        this.name = name;
        this.type = type;
        this.address = address;
        this.contactInfo = contactInfo;
    }

    public String toString() {
        return "Name: " + name + ", Type: " + type + 
               "Address: " + address.toString() + 
               "Contact Info: " + contactInfo.toString();
    }
    
}
