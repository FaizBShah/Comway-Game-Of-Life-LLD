package org.example;

import java.util.Objects;

public abstract class Cell {
    public abstract boolean isAlive();

    public Cell next(int numberOfAliveNeighbours) {
        if (numberOfAliveNeighbours < 0 || numberOfAliveNeighbours > 8) {
            throw new IllegalStateException("Number of neighbours of a cell can only be between 0 and 8");
        }

        return CellOperations.nextCell(isAlive(), numberOfAliveNeighbours);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isAlive());
    }
}
