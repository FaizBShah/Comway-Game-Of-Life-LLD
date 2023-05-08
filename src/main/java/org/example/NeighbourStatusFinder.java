package org.example;

public class NeighbourStatusFinder {
    public static int getNumberOfAliveNeighbours(int row, int col, Cell[][] board) {
        if (board == null) {
            throw new IllegalStateException("Initialized with an empty board");
        }

        if (board.length == 0 || board[0].length == 0) {
            throw new IllegalStateException("Invalid board size");
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            throw new IllegalStateException("Coordinates of the cell are out of bounds of the board size");
        }

        int[] xCoordinatesForNeighbours = { -1, 0, 1, -1, 1, -1, 0, 1 };
        int[] yCoordinatesForNeighbours = { 1, 1, 1, 0, 0, -1, -1, -1 };

        int count = 0;

        for (int k = 0; k < 8; k++) {
            int xPos = row + xCoordinatesForNeighbours[k];
            int yPos = col + yCoordinatesForNeighbours[k];

            if (xPos < 0 || yPos < 0 || xPos >= board.length || yPos >= board[0].length) {
                continue;
            }

            if (board[xPos][yPos] == null) {
                throw new IllegalStateException("All cells of the board must be non-null");
            }

            if (board[xPos][yPos].isAlive()) {
                count++;
            }
        }

        return count;
    }
}
