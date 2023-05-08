package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellOperationsTest {

    private Cell aliveCell;
    private Cell deadCell;

    @BeforeEach
    void setUp() {
        aliveCell = new AliveCell();
        deadCell = new DeadCell();
    }

    @Test
    void shouldReturnDeadCellIfNumberOfAliveNeighboursIsZero() {
        assertEquals(deadCell, CellOperations.nextCell(true, 0));
        assertEquals(deadCell, CellOperations.nextCell(false, 0));
    }

    @Test
    void shouldReturnDeadCellIfNumberOfAliveNeighboursIsOne() {
        assertEquals(deadCell, CellOperations.nextCell(true, 1));
        assertEquals(deadCell, CellOperations.nextCell(false, 1));
    }

    @Test
    void shouldReturnAliveCellIfNumberOfNeighboursIsTwoAndCellIsAlive() {
        assertEquals(aliveCell, CellOperations.nextCell(true, 2));
    }

    @Test
    void shouldReturnDeadCellIfNumberOfNeighboursIsTwoAndCellIsDead() {
        assertEquals(deadCell, CellOperations.nextCell(false, 2));
    }

    @Test
    void shouldReturnAliveCellIfNumberOfNeighboursIsThreeAndCellIsAlive() {
        assertEquals(aliveCell, CellOperations.nextCell(true, 3));
    }

    @Test
    void shouldReturnAliveCellIfNumberOfNeighboursIsThreeAndCellIsDead() {
        assertEquals(aliveCell, CellOperations.nextCell(false, 3));
    }

    @Test
    void shouldReturnDeadCellIfNumberOfAliveNeighboursIsFour() {
        assertEquals(deadCell, CellOperations.nextCell(true, 4));
        assertEquals(deadCell, CellOperations.nextCell(false, 4));
    }

    @Test
    void shouldReturnDeadCellIfNumberOfAliveNeighboursIsFive() {
        assertEquals(deadCell, CellOperations.nextCell(true, 5));
        assertEquals(deadCell, CellOperations.nextCell(false, 5));
    }

    @Test
    void shouldReturnDeadCellIfNumberOfAliveNeighboursIsSix() {
        assertEquals(deadCell, CellOperations.nextCell(true, 6));
        assertEquals(deadCell, CellOperations.nextCell(false, 6));
    }

    @Test
    void shouldReturnDeadCellIfNumberOfAliveNeighboursIsSeven() {
        assertEquals(deadCell, CellOperations.nextCell(true, 7));
        assertEquals(deadCell, CellOperations.nextCell(false, 7));
    }

    @Test
    void shouldReturnDeadCellIfNumberOfAliveNeighboursIsEight() {
        assertEquals(deadCell, CellOperations.nextCell(true, 8));
        assertEquals(deadCell, CellOperations.nextCell(false, 8));
    }

    @Test
    void shouldThrowAnErrorIfNumberOfAliveNeighboursIsLessThanZero() {
        Throwable exception1 = assertThrows(IllegalStateException.class, () -> CellOperations.nextCell(true, -1));
        Throwable exception2 = assertThrows(IllegalStateException.class, () -> CellOperations.nextCell(false, -1));

        assertEquals("Number of neighbours of a cell can only be between 0 and 8", exception1.getMessage());
        assertEquals("Number of neighbours of a cell can only be between 0 and 8", exception2.getMessage());
    }

    @Test
    void shouldThrowAnErrorIfNumberOfAliveNeighboursIsMoreThanEight() {
        Throwable exception1 = assertThrows(IllegalStateException.class, () -> CellOperations.nextCell(true, 9));
        Throwable exception2 = assertThrows(IllegalStateException.class, () -> CellOperations.nextCell(false, 9));

        assertEquals("Number of neighbours of a cell can only be between 0 and 8", exception1.getMessage());
        assertEquals("Number of neighbours of a cell can only be between 0 and 8", exception2.getMessage());
    }

}