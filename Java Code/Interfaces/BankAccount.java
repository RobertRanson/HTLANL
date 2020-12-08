public class BankAccount implements Account{
    private double balance = 0.0;

    public BankAccount(){

    }

    public void deposit(double amount) {
        this.balance += amount;
    }


    public boolean withdraw(double amount) {
        if (amount>this.balance){
            return false;
        }else{
            this.balance = this.balance - amount;
            return true;
        }
    }
    public double getBalance() {
        return balance;
    }
    public static void main(String[] args) {
        BankAccount myBankAccount = new BankAccount();
        myBankAccount.deposit(150.55);
        System.out.println(myBankAccount.getBalance());
        myBankAccount.withdraw(160.55);
        System.out.println(myBankAccount.getBalance());
        myBankAccount.withdraw(149.55);
        System.out.println(myBankAccount.getBalance());


    }
    
}