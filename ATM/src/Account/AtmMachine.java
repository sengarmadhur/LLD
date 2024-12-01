package Account;

import ATMStates.ATMState;
import ATMStates.IdleState;
import AmountWithdrawl.CashWithdrawProcessor;
import AmountWithdrawl.FiveHundredWithdrawProcessor;
import AmountWithdrawl.OneHundredWithdrawProcessor;
import AmountWithdrawl.TwoThousandWithdrawProcessor;

public class AtmMachine {

    ATMState currentState;
    private int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;


    //-------------––––––––––––-----Singleton ATM Machine -----------------------------
    private AtmMachine() {

    }

    private static class SingletonHelper {
        private static final AtmMachine INSTANCE = new AtmMachine();
    }

    public static AtmMachine getInstance() {

        AtmMachine machine =  SingletonHelper.INSTANCE;
        machine.setCurrentState(new IdleState());
        return machine;
    }

    //-------------––––––––––––-----Singleton ATM Machine -----------------------------


    public void setCurrentState(ATMState atmState) {
        this.currentState = atmState;
    }

    public ATMState getCurrentState() {
        return currentState;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance) {
        this.atmBalance = atmBalance;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public void setNoOfFiveHundredNotes(int noOfFiveHundredNotes) {
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
    }

    public void setNoOfOneHundredNotes(int noOfOneHundredNotes) {
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public void setNoOfTwoThousandNotes(int noOfTwoThousandNotes) {
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
    }

    public void deductAtmBalance(int amount) {
        atmBalance-=amount;
    }

    public void deductTwoThousandNotes(int number) {
        noOfTwoThousandNotes = noOfTwoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);

    }
}
