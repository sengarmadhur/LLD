import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playerList = new LinkedList<>();
    Player winner;

    public Game() {
        initializeGame();
    }
    void initializeGame(){
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    void addPlayers() {
        Player player1 = new Player("P1", 0);
        Player player2 = new Player("P2", 0);

        playerList.add(player1);
        playerList.add(player2);
    }

    public void startGame() {
        while (winner == null) {
            Player playerTurn = findPlayerTurn();

            System.out.println("Player turn is: " + playerTurn.getId() +
                    " current position is:" + playerTurn.currentPosition);
            int diceVal = dice.rollDice();
            System.out.println("Dice rolled to " + diceVal);


            int playerNewPos = diceVal + playerTurn.getCurrentPosition();
            playerNewPos = jumpCheck(playerNewPos);
            playerTurn.currentPosition = playerNewPos;

            if (playerNewPos >= board.cells.length*board.cells.length - 1) {
                winner = playerTurn;
            }
        }
        System.out.println("Winner is " + winner.getId());
    }

    Player findPlayerTurn() {
        Player  player = playerList.getFirst();
        playerList.removeFirst();
        playerList.addLast(player);
        return player;
    }

    int jumpCheck(int pos) {
        if (pos > board.cells.length*board.cells.length -1) {
            return pos;
        }

        Cell cell = board.getCell(pos);
        if (cell.jump != null && cell.jump.start == pos) {
            String jumpBy = (cell.jump.start < cell.jump.end)? "ladder" : "snake";
            System.out.println("jump done by: " + jumpBy + " from " +
                    cell.jump.start + " to " + cell.jump.end);

            pos = cell.jump.end;
        }
        return pos;
    }
}
