package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AliveCellTest {

    @Test
    void shouldAliveCellObjectBeCreatedSuccessfully() {
        assertDoesNotThrow(AliveCell::new);
    }

    @Test
    void shouldAliveCellIsAliveReturnTrue() {
        assertTrue(new AliveCell().isAlive());
    }

    @Test
    void shouldAnAliveCellDieIfItHasLessThanTwoNeighbours() {
        Cell cell1 = new AliveCell();
        Cell cell2 = new AliveCell();

        assertFalse(cell1.next(0).isAlive());
        assertFalse(cell2.next(1).isAlive());
    }

    @Test
    void shouldAnAliveCellRemainAliveIfItHasTwoOrThreeNeighbours() {
        Cell cell1 = new AliveCell();
        Cell cell2 = new AliveCell();

        assertTrue(cell1.next(2).isAlive());
        assertTrue(cell2.next(3).isAlive());
    }

    @Test
    void shouldAnAliveCellDieIfItHasMoreThanThreeNeighbours() {
        Cell cell1 = new AliveCell();
        Cell cell2 = new AliveCell();

        assertFalse(cell1.next(4).isAlive());
        assertFalse(cell2.next(7).isAlive());
    }

    @Test
    void shouldThrowErrorIfTryingToGetTheNextStateOfAnAliveCellWithLessThanZeroNeighbours() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> new AliveCell().next(-1));
        assertEquals("Number of neighbours of a cell can only be between 0 and 8", exception.getMessage());
    }

    @Test
    void shouldThrowErrorIfTryingToGetTheNextStateOfAnAliveCellWithMoreThanEightNeighbours() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> new AliveCell().next(9));
        assertEquals("Number of neighbours of a cell can only be between 0 and 8", exception.getMessage());
    }

}