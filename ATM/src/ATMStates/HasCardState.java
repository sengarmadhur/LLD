package ATMStates;

import Account.AtmMachine;
import Account.Card;

public class HasCardState extends ATMState {

    public HasCardState() {
        System.out.println("Enter Your PIN Number");
    }

    @Override
    public void authenticatePin(AtmMachine atmMachine, Card card, int pin) {
        if (card.validatePin(pin)) {
            atmMachine.setCurrentState(new SelectOperationState());
        } else {
            System.out.println("Invalid PIN");
            exit(atmMachine);
        }
    }
}
