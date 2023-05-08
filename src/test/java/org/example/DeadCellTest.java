package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadCellTest {

    @Test
    void shouldDeadCellObjectBeCreatedSuccessfully() {
        assertDoesNotThrow(DeadCell::new);
    }

    @Test
    void shouldDeadCellIsAliveReturnFalse() {
        assertFalse(new DeadCell().isAlive());
    }

    @Test
    void shouldADeadCellBecomeAliveIfItHasExactlyThreeNeighbours() {
        assertTrue(new DeadCell().next(3).isAlive());
    }

    @Test
    void shouldADeadCellRemainDeadIfItDoesNotHaveThreeNeighbours() {
        assertFalse(new DeadCell().next(2).isAlive());
        assertFalse(new DeadCell().next(4).isAlive());
    }

    @Test
    void shouldThrowErrorIfTryingToGetTheNextStateOfACellWithLessThanZeroNeighbours() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> new DeadCell().next(-1));
        assertEquals("Number of neighbours of a cell can only be between 0 and 8", exception.getMessage());
    }

    @Test
    void shouldThrowErrorIfTryingToGetTheNextStateOfACellWithMoreThanEightNeighbours() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> new DeadCell().next(9));
        assertEquals("Number of neighbours of a cell can only be between 0 and 8", exception.getMessage());
    }

}