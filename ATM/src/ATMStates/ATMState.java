package ATMStates;

import Account.*;

import java.nio.charset.CharacterCodingException;

public abstract class ATMState {
    public void insertCard(AtmMachine atmMachine, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void authenticatePin(AtmMachine atmMachine, Card card, int pin) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void selectOperation(AtmMachine atmMachine, Card card, TransactionType transactionType) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void cashWithdrawal(AtmMachine atmMachine, Card card, int amount) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void displayBalance(AtmMachine atmMachine, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void returnCard() {
        System.out.println("Please collect your card");
    }

    public void exit(AtmMachine atmMachine) {
        returnCard();
        atmMachine.setCurrentState(new IdleState());
        System.out.println("Exit happens");

    }

    public void showOperations() {
    }
}
