package org.example;

public class Cell {
    private final CellCharacter cellCharacter;

    public Cell(CellCharacter cellCharacter) {
        this.cellCharacter = cellCharacter;
    }

    public boolean isAlive() {
        return cellCharacter == CellCharacter.FILLED;
    }

    public Cell next(int numberOfAliveNeighbours) {
        if (numberOfAliveNeighbours < 0 || numberOfAliveNeighbours > 8) {
            throw new IllegalStateException("Number of neighbours of a cell can only be between 0 and 8");
        }

        CellCharacter nextCellCharacter = CellOperations.nextCellCharacter(isAlive(), numberOfAliveNeighbours);

        return new Cell(nextCellCharacter);
    }
}
