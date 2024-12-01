import Account.*;

public class ATMRoom {

    AtmMachine atmMachine = AtmMachine.getInstance();
    User user;

    public ATMRoom() {
    }

    public void initialize() {
        UserBankAccount userBankAccount = new UserBankAccount();
        userBankAccount.setBalance(5000);

        Card card = new Card();
        card.setUserBankAccount(userBankAccount);

        user = new User();
        user.setCard(card);
        user.setUserBankAccount(userBankAccount);


        atmMachine.setAtmBalance(10000);
        atmMachine.setNoOfTwoThousandNotes(1);
        atmMachine.setNoOfFiveHundredNotes(2);
        atmMachine.setNoOfOneHundredNotes(70);
        atmMachine.printCurrentATMStatus();

        atmMachine.getCurrentState().insertCard(atmMachine, card);
        atmMachine.getCurrentState().authenticatePin(atmMachine, card, 112233);
        atmMachine.getCurrentState().selectOperation(atmMachine, card, TransactionType.CASH_WITHDRAWL);
        atmMachine.getCurrentState().cashWithdrawal(atmMachine, card, 4700);
        atmMachine.printCurrentATMStatus();
    }
}
