package AmountWithdrawl;

import Account.AtmMachine;

public abstract class CashWithdrawProcessor {
    CashWithdrawProcessor nextWithdrawProcessor;

    CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        nextWithdrawProcessor = cashWithdrawProcessor;
    }

    public void withdraw(AtmMachine atmMachine, int amount) {
        if (nextWithdrawProcessor != null) {
            nextWithdrawProcessor.withdraw(atmMachine, amount);
        }
    }
}
