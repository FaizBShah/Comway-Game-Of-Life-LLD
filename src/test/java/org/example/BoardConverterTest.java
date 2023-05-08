package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.example.CellStatus.*;

class BoardConverterTest {

    @Test
    void shouldConvertCellBoardToCellStatusBoardCorrectly() {
        Cell[][] board = new Cell[2][2];

        board[0][0] = new DeadCell();
        board[0][1] = new AliveCell();
        board[1][0] = new AliveCell();
        board[1][1] = new DeadCell();

        CellStatus[][] expectedBoard = {
                { EMPTY, FILLED },
                { FILLED, EMPTY }
        };

        CellStatus[][] resultBoard = BoardConverter.convertCellBoardToCellStatusBoard(board);

        assertEquals(expectedBoard.length, resultBoard.length);
        assertEquals(expectedBoard[0].length, resultBoard[0].length);

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                assertEquals(expectedBoard[row][col], resultBoard[row][col]);
            }
        }
    }

    @Test
    void shouldThrowAnErrorIfTryingToPassANullObjectDuringCellBoardToCellStatusBoardConversion() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> BoardConverter.convertCellBoardToCellStatusBoard(null));
        assertEquals("Initialized with an empty board", exception.getMessage());
    }

    @Test
    void shouldThrowAnErrorIfTryingToPassACellBoardOfInvalidLengthDuringCellBoardToCellStatusBoardConversion() {
        Cell[][] board = new Cell[0][0];

        Throwable exception = assertThrows(IllegalStateException.class, () -> BoardConverter.convertCellBoardToCellStatusBoard(board));

        assertEquals("Invalid board size", exception.getMessage());
    }

    @Test
    void shouldThrowAnErrorIfCellsAreNullDuringCellBoardToCellStatusBoardConversion() {
        Cell[][] board = new Cell[3][3];

        Throwable exception = assertThrows(IllegalStateException.class, () -> BoardConverter.convertCellBoardToCellStatusBoard(board));

        assertEquals("All cells of the board must be non-null", exception.getMessage());
    }

    @Test
    void shouldConvertCellStatusBoardToCellBoardCorrectly() {
        CellStatus[][] board = {
                { EMPTY, FILLED },
                { FILLED, EMPTY }
        };

        Cell[][] expectedBoard = new Cell[2][2];

        expectedBoard[0][0] = new DeadCell();
        expectedBoard[0][1] = new AliveCell();
        expectedBoard[1][0] = new AliveCell();
        expectedBoard[1][1] = new DeadCell();

        Cell[][] resultBoard = BoardConverter.convertCellStatusBoardToCellBoard(board);

        assertEquals(expectedBoard.length, resultBoard.length);
        assertEquals(expectedBoard[0].length, resultBoard[0].length);

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                assertEquals(expectedBoard[row][col], resultBoard[row][col]);
            }
        }
    }

    @Test
    void shouldThrowAnErrorIfTryingToPassANullObjectDuringCellStatusBoardToCellBoardConversion() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> BoardConverter.convertCellStatusBoardToCellBoard(null));
        assertEquals("Initialized with an empty board", exception.getMessage());
    }

    @Test
    void shouldThrowAnErrorIfTryingToPassACellStatusBoardOfInvalidLengthDuringCellStatusBoardToCellBoardConversion() {
        CellStatus[][] board = new CellStatus[0][0];

        Throwable exception = assertThrows(IllegalStateException.class, () -> BoardConverter.convertCellStatusBoardToCellBoard(board));

        assertEquals("Invalid board size", exception.getMessage());
    }

    @Test
    void shouldThrowAnErrorIfCellsAreNullDuringCellStatusBoardToCellBoardConversion() {
        CellStatus[][] board = new CellStatus[3][3];

        Throwable exception = assertThrows(IllegalStateException.class, () -> BoardConverter.convertCellStatusBoardToCellBoard(board));

        assertEquals("All cells of the board must be non-null", exception.getMessage());
    }

}