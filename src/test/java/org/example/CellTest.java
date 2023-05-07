package org.example;

import org.junit.jupiter.api.Test;

import static org.example.CellCharacter.EMPTY;
import static org.example.CellCharacter.FILLED;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void shouldCellObjectBeCreatedSuccessfully() {
        assertDoesNotThrow(() -> new Cell(FILLED));
        assertDoesNotThrow(() -> new Cell(EMPTY));
    }

    @Test
    void shouldReturnTrueIfCellIsAlive() {
        assertTrue(new Cell(FILLED).isAlive());
    }

    @Test
    void shouldReturnFalseIfCellIsAlive() {
        assertFalse(new Cell(EMPTY).isAlive());
    }

    @Test
    void shouldAnAliveCellDieIfItHasLessThanTwoNeighbours() {
        Cell cell1 = new Cell(FILLED);
        Cell cell2 = new Cell(FILLED);

        assertFalse(cell1.next(0).isAlive());
        assertFalse(cell2.next(1).isAlive());
    }

    @Test
    void shouldAnAliveCellRemainAliveIfItHasTwoOrThreeNeighbours() {
        Cell cell1 = new Cell(FILLED);
        Cell cell2 = new Cell(FILLED);

        assertTrue(cell1.next(2).isAlive());
        assertTrue(cell2.next(3).isAlive());
    }

    @Test
    void shouldAnAliveCellDieIfItHasMoreThanThreeNeighbours() {
        Cell cell1 = new Cell(FILLED);
        Cell cell2 = new Cell(FILLED);

        assertFalse(cell1.next(4).isAlive());
        assertFalse(cell2.next(7).isAlive());
    }

    @Test
    void shouldADeadCellBecomeAliveIfItHasExactlyThreeNeighbours() {
        assertTrue(new Cell(EMPTY).next(3).isAlive());
    }

    @Test
    void shouldADeadCellRemainDeadIfItDoesNotHaveThreeNeighbours() {
        assertFalse(new Cell(EMPTY).next(2).isAlive());
        assertFalse(new Cell(EMPTY).next(4).isAlive());
    }

    @Test
    void shouldThrowErrorIfTryingToGetTheNextStateOfACellWithLessThanZeroNeighbours() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> new Cell(FILLED).next(-1));
        assertEquals("Number of neighbours of a cell can only be between 0 and 8", exception.getMessage());
    }

    @Test
    void shouldThrowErrorIfTryingToGetTheNextStateOfACellWithMoreThanEightNeighbours() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> new Cell(FILLED).next(9));
        assertEquals("Number of neighbours of a cell can only be between 0 and 8", exception.getMessage());
    }

}