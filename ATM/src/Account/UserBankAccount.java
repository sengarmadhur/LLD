package Account;

public class UserBankAccount {
    int balance;

    public void withdrawBalance(int amount) {
        balance = balance - amount;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
