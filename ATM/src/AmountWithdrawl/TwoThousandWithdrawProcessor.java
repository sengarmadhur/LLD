package AmountWithdrawl;

import Account.AtmMachine;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor{
    public TwoThousandWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }

    @Override
    public void withdraw(AtmMachine atmMachine, int amount) {
        int required = amount/2000;
        int balance = amount%2000;

        if (required <= atmMachine.getNoOfTwoThousandNotes()) {
            atmMachine.deductTwoThousandNotes(required);
        } else {
            int notes2000 = atmMachine.getNoOfTwoThousandNotes();
            atmMachine.deductTwoThousandNotes(atmMachine.getNoOfTwoThousandNotes());
            balance = balance + (required - notes2000)*2000;
        }

        if (balance != 0) {
            super.withdraw(atmMachine, balance);
        }
    }
}
