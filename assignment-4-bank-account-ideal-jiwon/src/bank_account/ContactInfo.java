package bank_account;

public class ContactInfo {

    String phone;
    String email; 

    public ContactInfo(String phone, String email){
        this.phone = phone;
        this.email = email;
    }

    public String toString(){
        return "Phone number is : " + phone + " . " + "Email address is : " + email;
    }
}
