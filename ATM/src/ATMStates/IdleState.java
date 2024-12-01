package ATMStates;

import Account.AtmMachine;
import Account.Card;

public class IdleState extends ATMState{

    @Override
    public void insertCard(AtmMachine atmMachine, Card card) {
        System.out.println("Card is inserted");
        atmMachine.setCurrentState(new HasCardState());
    }
}
