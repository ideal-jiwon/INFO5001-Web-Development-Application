package bank_account;

public class BankAccount {
    OwnerProfile ownerProfile;
    String currency;
    String type;
    int balance;
    
    public BankAccount(OwnerProfile ownerProfile, String currency, String type, int balance) {
        this.ownerProfile = ownerProfile; 
        this.currency = currency;
        this.type = type;
        this.balance = balance;
    }

    public void deposit(double amount){
        System.out.println("Deposite amount : " + amount);
        this.balance += amount;
    }
    public void withdraw(double amount){
        System.out.println("Withdraw amount : " + amount);
        this.balance-=amount;
    }
    public void getBalance(){
        System.out.println("This is the balance : " + balance);
    }
    public String toString(){
        return "Bank Account Information : " + '\n'+ "Currency : " + currency + " " + "Type : " + type + "Balance : " + balance + + '\n'+ ownerProfile.toString(); 
    }        

}
