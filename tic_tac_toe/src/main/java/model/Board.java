package model;

public class Board {

	private final Cell[][] grid;

    public Board() {
        grid = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public void setMark(int row, int col, MarkType mark) {
        if (isValidPosition(row, col)) {
            grid[row][col].setMark(mark);
        } else {
            throw new IllegalArgumentException("Invalid board position");
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return isValidPosition(row, col) && grid[row][col].isEmpty();
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWinner(MarkType mark) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((grid[i][0].getMark() == mark && grid[i][1].getMark() == mark && grid[i][2].getMark() == mark) ||
                (grid[0][i].getMark() == mark && grid[1][i].getMark() == mark && grid[2][i].getMark() == mark)) {
                return true;
            }
        }
        // Check diagonals
        return (grid[0][0].getMark() == mark && grid[1][1].getMark() == mark && grid[2][2].getMark() == mark) ||
               (grid[0][2].getMark() == mark && grid[1][1].getMark() == mark && grid[2][0].getMark() == mark);
    }

    public void displayBoard() {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                MarkType mark = grid[i][j].getMark();
                String symbol = (mark == MarkType.EMPTY) ? "-" : mark.toString();
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void emptyBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j].reset();
            }
        }
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }
}
