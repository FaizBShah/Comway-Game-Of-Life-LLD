package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.example.CellCharacter.*;

class CellOperationsTest {

    @Test
    void shouldReturnEmptyIfNumberOfAliveNeighboursIsZero() {
        assertEquals(EMPTY, CellOperations.nextCellCharacter(true, 0));
        assertEquals(EMPTY, CellOperations.nextCellCharacter(false, 0));
    }

    @Test
    void shouldReturnEmptyIfNumberOfAliveNeighboursIsOne() {
        assertEquals(EMPTY, CellOperations.nextCellCharacter(true, 1));
        assertEquals(EMPTY, CellOperations.nextCellCharacter(false, 1));
    }

    @Test
    void shouldReturnFilledIfNumberOfNeighboursIsTwoAndCellIsAlive() {
        assertEquals(FILLED, CellOperations.nextCellCharacter(true, 2));
    }

    @Test
    void shouldReturnEmptyIfNumberOfNeighboursIsTwoAndCellIsDead() {
        assertEquals(EMPTY, CellOperations.nextCellCharacter(false, 2));
    }

    @Test
    void shouldReturnFilledIfNumberOfNeighboursIsThreeAndCellIsAlive() {
        assertEquals(FILLED, CellOperations.nextCellCharacter(true, 3));
    }

    @Test
    void shouldReturnFilledIfNumberOfNeighboursIsThreeAndCellIsDead() {
        assertEquals(FILLED, CellOperations.nextCellCharacter(false, 3));
    }

    @Test
    void shouldReturnEmptyIfNumberOfAliveNeighboursIsFour() {
        assertEquals(EMPTY, CellOperations.nextCellCharacter(true, 4));
        assertEquals(EMPTY, CellOperations.nextCellCharacter(false, 4));
    }

    @Test
    void shouldReturnEmptyIfNumberOfAliveNeighboursIsFive() {
        assertEquals(EMPTY, CellOperations.nextCellCharacter(true, 5));
        assertEquals(EMPTY, CellOperations.nextCellCharacter(false, 5));
    }

    @Test
    void shouldReturnEmptyIfNumberOfAliveNeighboursIsSix() {
        assertEquals(EMPTY, CellOperations.nextCellCharacter(true, 6));
        assertEquals(EMPTY, CellOperations.nextCellCharacter(false, 6));
    }

    @Test
    void shouldReturnEmptyIfNumberOfAliveNeighboursIsSeven() {
        assertEquals(EMPTY, CellOperations.nextCellCharacter(true, 7));
        assertEquals(EMPTY, CellOperations.nextCellCharacter(false, 7));
    }

    @Test
    void shouldReturnEmptyIfNumberOfAliveNeighboursIsEight() {
        assertEquals(EMPTY, CellOperations.nextCellCharacter(true, 8));
        assertEquals(EMPTY, CellOperations.nextCellCharacter(false, 8));
    }

    @Test
    void shouldThrowAnErrorIfNumberOfAliveNeighboursIsLessThanZero() {
        Throwable exception1 = assertThrows(IllegalStateException.class, () -> CellOperations.nextCellCharacter(true, -1));
        Throwable exception2 = assertThrows(IllegalStateException.class, () -> CellOperations.nextCellCharacter(false, -1));

        assertEquals("Number of neighbours of a cell can only be between 0 and 8", exception1.getMessage());
        assertEquals("Number of neighbours of a cell can only be between 0 and 8", exception2.getMessage());
    }

    @Test
    void shouldThrowAnErrorIfNumberOfAliveNeighboursIsMoreThanEight() {
        Throwable exception1 = assertThrows(IllegalStateException.class, () -> CellOperations.nextCellCharacter(true, 9));
        Throwable exception2 = assertThrows(IllegalStateException.class, () -> CellOperations.nextCellCharacter(false, 9));

        assertEquals("Number of neighbours of a cell can only be between 0 and 8", exception1.getMessage());
        assertEquals("Number of neighbours of a cell can only be between 0 and 8", exception2.getMessage());
    }

}