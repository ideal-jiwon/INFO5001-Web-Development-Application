package bank_account;

public class BankAccountExample {

    public static void main(String[]args) throws Exception{
        // 1,2 Create three different bank account instances with owners and owner information

        ContactInfo contact1 = new ContactInfo("571-353-9600", "annest94@gmail.com");
        Address address1 = new Address("111 towne streeet 111", "NewYork", "NY", "US", "06902");
        OwnerProfile user1 = new OwnerProfile("Stellar Jiwon Mok", "individual", address1, contact1);
        BankAccount account1 = new BankAccount(user1, "USD", "Checking",10000);
        

        ContactInfo contact2 = new ContactInfo("913-579-3868", "alexbrivik@gmail.com");
        Address address2 = new Address("111 towne streeet 111", "NewYork", "NY", "US", "06902");
        OwnerProfile user2 = new OwnerProfile("Alex Brivik", "individual",address2, contact2);
        BankAccount account2 = new BankAccount(user2, "USD", "Checking",20000);

        ContactInfo contact3 = new ContactInfo("111-222-4444", "patriciarios@gmail.com");
        Address address3 = new Address("5370 Toscana Way, H219", "San Diego", "CA", "US", "92122");
        OwnerProfile user3 = new OwnerProfile("Patricia Rios ", "individual",address3, contact3);
        BankAccount account3 = new BankAccount(user3, "USD", "Checking",17000);
        
        // 3. owners, addresses & contact information
        // Access and display account bank account (Including owner profile / contactinfo/ address )

        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);
    }
}
