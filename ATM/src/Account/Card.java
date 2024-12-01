package Account;

public class Card {

    int cardNumber;
    int PIN_NUMBER = 112233;
    int cvv;
    int expiryDate;
    String holderName;
    UserBankAccount userBankAccount;

    public boolean validatePin(int pin) {
        return pin == PIN_NUMBER;
    }

    public int getBankBalance() {
        return userBankAccount.balance;
    }

    public void deductBankBalance(int amount) {
        userBankAccount.withdrawBalance(amount);
    }

    public void setUserBankAccount(UserBankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }
}
