package org.example;

import java.security.SecureRandom;

public class Game {
    private Board board;

    public void startWithBoard(CellStatus[][] starterBoard) {
        if (board != null) {
            throw new IllegalStateException("Game has already been started with a board");
        }

        if (starterBoard == null) {
            throw new IllegalStateException("Initialized with an empty board");
        }

        if (starterBoard.length == 0 || starterBoard[0].length == 0) {
            throw new IllegalStateException("Invalid board size");
        }

        board = new Board(starterBoard);
    }

    public void startWithRandomBoardOfSize(int rows, int cols) {
        if (board != null) {
            throw new IllegalStateException("Game has already been started with a board");
        }

        if (rows < 0 || cols < 0) {
            throw new IllegalStateException("Dimensions of the board should be valid");
        }

        CellStatus[][] starterBoard = new CellStatus[rows][cols];
        CellStatus[] characters = CellStatus.values();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               starterBoard[i][j] = characters[new SecureRandom().nextInt(characters.length)];
            }
        }

        board = new Board(starterBoard);
    }

    public CellStatus[][] tick() {
        if (board == null) {
            throw new IllegalStateException("Game has not been initialized with a board yet");
        }

        return board.next();
    }

    public CellStatus[][] tick(int n) {
        if (board == null) {
            throw new IllegalStateException("Game has not been initialized with a board yet");
        }

        for (int i = 0; i < n - 1; i++) {
            board.next();
        }

        return board.next();
    }

    public void stop() {
        if (board == null) {
            throw new IllegalStateException("There is no game currently being run that could be stopped");
        }

        board = null;
    }
}
