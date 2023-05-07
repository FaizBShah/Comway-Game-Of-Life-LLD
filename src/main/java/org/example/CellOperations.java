package org.example;

import java.util.HashMap;
import java.util.function.Function;

import static org.example.CellCharacter.*;

public class CellOperations {
    private static final HashMap<Integer, Function<Boolean, Boolean>> cellFunctionsMapping = new HashMap<>() {{
        put(2, (isAlive) -> isAlive);
        put(3, (isAlive) -> true);
    }};

    public static CellCharacter nextCellCharacter(boolean isAlive, int numberOfAliveNeighbours) {
        if (numberOfAliveNeighbours < 0 || numberOfAliveNeighbours > 8) {
            throw new IllegalStateException("Number of neighbours of a cell can only be between 0 and 8");
        }

        return cellFunctionsMapping.getOrDefault(numberOfAliveNeighbours, (alive) -> false).apply(isAlive) ? FILLED : EMPTY;
    }
}
