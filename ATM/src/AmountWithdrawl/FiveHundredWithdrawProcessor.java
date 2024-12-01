package AmountWithdrawl;

import Account.AtmMachine;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor{
    public FiveHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }

    @Override
    public void withdraw(AtmMachine atmMachine, int amount) {
        int required = amount/500;
        int balance = amount%500;

        if (required <= atmMachine.getNoOfFiveHundredNotes()) {
            atmMachine.deductFiveHundredNotes(required);
        } else {
            int notes500 = atmMachine.getNoOfFiveHundredNotes();
            atmMachine.deductFiveHundredNotes(atmMachine.getNoOfFiveHundredNotes());
            balance = balance + (required - notes500)*500;
        }

        if (balance != 0) {
            super.withdraw(atmMachine, balance);
        }
    }
}
