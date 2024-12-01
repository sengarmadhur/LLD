package Account;

public enum TransactionType {
    CASH_WITHDRAWL,
    BALANCE_CHECK;

    public static void showAllTransactionTypes() {
        for (TransactionType transactionType: TransactionType.values()) {
            System.out.println(transactionType.name());
        }
    }
}
