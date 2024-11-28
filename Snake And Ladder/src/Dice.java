import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    int diceCount;
    int min = 1;
    int max = 6;

    public Dice(int cnt) {
        diceCount = cnt;
    }

    public int rollDice() {
        int totalSum = 0;
        int diceUsed = diceCount;
        while( diceUsed > 0) {
            diceUsed--;
            totalSum+=ThreadLocalRandom.current().nextInt(min, max);
        }
        return totalSum;
    }
}
