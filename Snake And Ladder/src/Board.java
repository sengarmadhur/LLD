import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;

    public Board(int boardSize, int snake, int ladder) {
        initializeCells(boardSize);
        addSnakeAndLadder(snake, ladder);
    }

    void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for (int i=0; i<boardSize; i++) {
            for (int j=0; j<boardSize; j++) {
                cells[i][j] = new Cell();
                cells[i][j].number = boardSize*i + j;
            }
        }
    }

    void addSnakeAndLadder(int snake, int ladder) {
        while (snake > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1,
                    cells.length * cells.length -1);
            int snakeTail = ThreadLocalRandom.current().nextInt(0,
                    snakeHead -1);
            Jump snakeJump = new Jump();
            snakeJump.start  = snakeHead;
            snakeJump.end = snakeTail;

            Cell cell = getCell(snakeHead);
            cell.jump = snakeJump;
            snake--;
        }

        while (ladder > 0) {
            int ladderHead = ThreadLocalRandom.current().nextInt(1,
                    cells.length * cells.length -2);
            int ladderTail = ThreadLocalRandom.current().nextInt(ladderHead + 1,
                    cells.length * cells.length -1);
            Jump ladderJump = new Jump();
            ladderJump.start  = ladderHead;
            ladderJump.end = ladderTail;

            Cell cell = getCell(ladderHead);
            cell.jump = ladderJump;
            ladder--;
        }
    }

    Cell getCell(int playerPos) {
        int row = playerPos/ cells.length;
        int col = playerPos % cells.length;
        return  cells[row][col];
    }
}
