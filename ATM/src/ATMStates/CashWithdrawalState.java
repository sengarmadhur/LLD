package ATMStates;

import Account.AtmMachine;
import Account.Card;
import AmountWithdrawl.CashWithdrawProcessor;
import AmountWithdrawl.FiveHundredWithdrawProcessor;
import AmountWithdrawl.OneHundredWithdrawProcessor;
import AmountWithdrawl.TwoThousandWithdrawProcessor;

public class CashWithdrawalState extends ATMState {
    private static CashWithdrawProcessor cashWithdrawProcessor = new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));;
    public CashWithdrawalState() {
        System.out.println("Please enter withdrawal amount");
    }

    @Override
    public void cashWithdrawal(AtmMachine atmMachine, Card card, int amount) {
        if (atmMachine.getAtmBalance() < amount) {
            System.out.println("Insufficient funds in ATM");
            exit(atmMachine);
        } else if (card.getBankBalance() < amount) {
            System.out.println("Insufficient fund in your Bank Account");
            exit(atmMachine);
        } else {
            card.deductBankBalance(amount);
            atmMachine.deductAtmBalance(amount);
            cashWithdrawProcessor.withdraw(atmMachine, amount);
        }
    }

}
