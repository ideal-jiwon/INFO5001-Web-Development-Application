package bank_account;

public class Address {

    String street;
    String city;
    String state;
    String country;
    String postalCode;

    public Address(String street, String city, String state, String country, String postalCode){

    this.street = street;
    this.city = city;
    this.state = state;
    this.country = country;
    this.postalCode = postalCode; 
    }
    public String toString(){
        return " The address is : " + street + " , "+ city +" , " + state + " , " + country + " , " + postalCode;
    }
}
