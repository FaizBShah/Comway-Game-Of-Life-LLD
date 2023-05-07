package org.example;

import static org.example.CellCharacter.*;

public class Board {
    private Cell[][] board;
    private final int rows;
    private final int cols;

    public Board(CellCharacter[][] board) {
        if (board == null) {
            throw new IllegalStateException("Initialized with an empty board");
        }

        if (board.length == 0 || board[0].length == 0) {
            throw new IllegalStateException("Invalid board size");
        }

        rows = board.length;
        cols = board[0].length;

        this.board = new Cell[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.board[i][j] = new Cell(board[i][j]);
            }
        }
    }

    public CellCharacter[][] next() {
        Cell[][] tempNewBoard = new Cell[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int numberOfAliveNeighbours = getNumberOfAliveNeighbours(i, j);
                tempNewBoard[i][j] = board[i][j].next(numberOfAliveNeighbours);
            }
        }

        board = tempNewBoard;

        return convertCellBoardToCharBoard();
    }

    private int getNumberOfAliveNeighbours(int i, int j) {
        int[] x = { -1, 0, 1, -1, 1, -1, 0, 1 };
        int[] y = { 1, 1, 1, 0, 0, -1, -1, -1 };

        int count = 0;

        for (int k = 0; k < 8; k++) {
            int xPos = i + x[k];
            int yPos = j + y[k];

            if (xPos < 0 || yPos < 0 || xPos >= rows || yPos >= cols) {
                continue;
            }

            if (board[xPos][yPos].isAlive()) {
                count++;
            }
        }

        return count;
    }

    private CellCharacter[][] convertCellBoardToCharBoard() {
        CellCharacter[][] resBoard = new CellCharacter[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resBoard[i][j] = board[i][j].isAlive() ? FILLED : EMPTY;
            }
        }

        return resBoard;
    }
}
