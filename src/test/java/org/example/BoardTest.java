package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.example.CellStatus.*;

class BoardTest {

    @Test
    void shouldBoardObjectGetCreatedSuccessfully() {
        CellStatus[][] gameBoard = {
                { EMPTY, EMPTY, FILLED },
                { EMPTY, EMPTY, EMPTY },
                { FILLED, FILLED, EMPTY }
        };
        assertDoesNotThrow(()  -> new Board(gameBoard));
    }

    @Test
    void shouldThrowAnErrorIfTryingToPassANullObjectDuringBoardObjectCreation() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> new Board(null));
        assertEquals("Initialized with an empty board", exception.getMessage());
    }

    @Test
    void shouldThrowAnErrorIfTryingToPassABoardOfInvalidLength() {
        CellStatus[][] gameBoard = new CellStatus[0][0];

        Throwable exception = assertThrows(IllegalStateException.class, () -> new Board(gameBoard));

        assertEquals("Invalid board size", exception.getMessage());
    }

    @Test
    void shouldThrowAnErrorIfTryingToPassABoardWithNullCells() {
        CellStatus[][] gameBoard = new CellStatus[3][3];

        Throwable exception = assertThrows(IllegalStateException.class, () -> new Board(gameBoard));

        assertEquals("All cells of the board must be non-null", exception.getMessage());
    }

    @Test
    void shouldGenerateCorrectNextBoard() {
        CellStatus[][] gameBoard = {
                { EMPTY, EMPTY, FILLED },
                { EMPTY, FILLED, EMPTY },
                { FILLED, FILLED, EMPTY }
        };
        CellStatus[][] expectedGameBoard = {
                { EMPTY, EMPTY, EMPTY },
                { FILLED, FILLED, FILLED },
                { FILLED, FILLED, EMPTY }
        };

        Board board = new Board(gameBoard);
        CellStatus[][] resultGameBoard = board.next();

        assertEquals(expectedGameBoard.length, resultGameBoard.length);
        assertEquals(expectedGameBoard[0].length, resultGameBoard[0].length);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(expectedGameBoard[i][j], resultGameBoard[i][j]);
            }
        }
    }

}