package AmountWithdrawl;

import Account.AtmMachine;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor{
    public OneHundredWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }

    @Override
    public void withdraw(AtmMachine atmMachine, int amount) {
        int required = amount/100;
        int balance = amount%100;

        if (required <= atmMachine.getNoOfOneHundredNotes()) {
            atmMachine.deductOneHundredNotes(required);
        } else {
            int notes100 = atmMachine.getNoOfOneHundredNotes();
            atmMachine.deductOneHundredNotes(atmMachine.getNoOfOneHundredNotes());
            balance = balance + (required - notes100)*100;
        }

        if (balance != 0) {
            super.withdraw(atmMachine, balance);
        }
    }
}
