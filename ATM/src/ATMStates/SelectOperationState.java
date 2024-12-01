package ATMStates;

import Account.AtmMachine;
import Account.Card;
import Account.TransactionType;

public class SelectOperationState extends ATMState {

    public SelectOperationState() {
        showOperations();
    }

    public void selectOperation(AtmMachine atmMachine, Card card, TransactionType transactionType) {

        switch (transactionType) {
            case BALANCE_CHECK:
                atmMachine.setCurrentState(new CheckBalanceState());
                break;
            case CASH_WITHDRAWL:
                atmMachine.setCurrentState(new CashWithdrawalState());
                break;
            default: {
                System.out.println("Invalid option");
                exit(atmMachine);
            }
        }
    }

    public void showOperations() {
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }
}
