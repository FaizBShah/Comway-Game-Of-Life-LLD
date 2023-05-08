package org.example;

import static org.example.CellStatus.*;

public class BoardConverter {
    public static CellStatus[][] convertCellBoardToCellStatusBoard(Cell[][] board) {
        if (board == null) {
            throw new IllegalStateException("Initialized with an empty board");
        }

        if (board.length == 0 || board[0].length == 0) {
            throw new IllegalStateException("Invalid board size");
        }

        int rows = board.length;
        int cols = board[0].length;

        CellStatus[][] resBoard = new CellStatus[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == null) {
                    throw new IllegalStateException("All cells of the board must be non-null");
                }

                resBoard[i][j] = board[i][j].isAlive() ? FILLED : EMPTY;
            }
        }

        return resBoard;
    }

    public static Cell[][] convertCellStatusBoardToCellBoard(CellStatus[][] board) {
        if (board == null) {
            throw new IllegalStateException("Initialized with an empty board");
        }

        if (board.length == 0 || board[0].length == 0) {
            throw new IllegalStateException("Invalid board size");
        }

        int rows = board.length;
        int cols = board[0].length;

        Cell[][] resBoard = new Cell[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == null) {
                    throw new IllegalStateException("All cells of the board must be non-null");
                }

                resBoard[i][j] = board[i][j] == FILLED ? new AliveCell() : new DeadCell();
            }
        }

        return resBoard;
    }
}
