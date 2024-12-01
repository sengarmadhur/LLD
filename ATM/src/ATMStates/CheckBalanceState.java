package ATMStates;

import Account.AtmMachine;
import Account.Card;

public class CheckBalanceState extends ATMState {

    public void checkBalance(AtmMachine atmMachine, Card card) {
        System.out.println("Your balance is: " + card.getBankBalance());
        exit(atmMachine);
    }
}
