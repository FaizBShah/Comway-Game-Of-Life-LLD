package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeighbourStatusFinderTest {

    @Test
    void shouldFindTheCorrectNumberOfAliveNeighboursOfACell() {
        Cell[][] board = new Cell[3][3];

        board[0][0] = new DeadCell();
        board[0][1] = new DeadCell();
        board[0][2] = new AliveCell();
        board[1][0] = new DeadCell();
        board[1][1] = new AliveCell();
        board[1][2] = new DeadCell();
        board[2][0] = new AliveCell();
        board[2][1] = new AliveCell();
        board[2][2] = new DeadCell();

        assertEquals(3, NeighbourStatusFinder.getNumberOfAliveNeighbours(1, 1, board));
    }

    @Test
    void shouldThrowAnErrorIfTryingToPassANullBoardObjectDuringFindingTheNumberOfAliveNeighbours() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> NeighbourStatusFinder.getNumberOfAliveNeighbours(1, 2, null));
        assertEquals("Initialized with an empty board", exception.getMessage());
    }

    @Test
    void shouldThrowAnErrorIfTryingToPassABoardOfInvalidLength() {
        Cell[][] gameBoard = new Cell[0][0];

        Throwable exception = assertThrows(IllegalStateException.class, () -> NeighbourStatusFinder.getNumberOfAliveNeighbours(1, 2, gameBoard));

        assertEquals("Invalid board size", exception.getMessage());
    }

    @Test
    void shouldThrowAnErrorIfTryingToPassInvalidCellCoordinates() {
        Cell[][] board = new Cell[3][3];

        board[0][0] = new DeadCell();
        board[0][1] = new DeadCell();
        board[0][2] = new AliveCell();
        board[1][0] = new DeadCell();
        board[1][1] = new AliveCell();
        board[1][2] = new DeadCell();
        board[2][0] = new AliveCell();
        board[2][1] = new AliveCell();
        board[2][2] = new DeadCell();

        Throwable exception = assertThrows(IllegalStateException.class, () -> NeighbourStatusFinder.getNumberOfAliveNeighbours(4, -1, board));

        assertEquals("Coordinates of the cell are out of bounds of the board size", exception.getMessage());
    }

    @Test
    void shouldThrowAnErrorIfCellsAreNull() {
        Cell[][] board = new Cell[3][3];

        Throwable exception = assertThrows(IllegalStateException.class, () -> NeighbourStatusFinder.getNumberOfAliveNeighbours(1, 1, board));

        assertEquals("All cells of the board must be non-null", exception.getMessage());
    }

}