package model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {


    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testBoardIsInitiallyEmpty() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void testSetMarkAndGetMark() {
        board.setMark(0, 1, MarkType.X);
        assertFalse(board.isCellEmpty(0, 1));
    }

    @Test
    void testEmptyBoard() {
        board.setMark(1, 1, MarkType.O);
        board.emptyBoard();
        assertTrue(board.isCellEmpty(1, 1));
    }

    @Test
    void testIsBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.setMark(i, j, MarkType.X);
            }
        }
        assertTrue(board.isBoardFull());
    }

    @Test
    void testCheckWinnerRow() {
        board.setMark(0, 0, MarkType.X);
        board.setMark(0, 1, MarkType.X);
        board.setMark(0, 2, MarkType.X);
        assertTrue(board.checkWinner(MarkType.X));
    }

    @Test
    void testCheckWinnerColumn() {
        board.setMark(0, 1, MarkType.O);
        board.setMark(1, 1, MarkType.O);
        board.setMark(2, 1, MarkType.O);
        assertTrue(board.checkWinner(MarkType.O));
    }

    @Test
    void testCheckWinnerDiagonal() {
        board.setMark(0, 0, MarkType.X);
        board.setMark(1, 1, MarkType.X);
        board.setMark(2, 2, MarkType.X);
        assertTrue(board.checkWinner(MarkType.X));
    }

    @Test
    void testNoWinner() {
        assertFalse(board.checkWinner(MarkType.X));
    }
}
