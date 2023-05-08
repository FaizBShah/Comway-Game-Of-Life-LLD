package org.example;

public class Board {
    private Cell[][] board;
    private final int rows;
    private final int cols;

    public Board(CellStatus[][] board) {
        if (board == null) {
            throw new IllegalStateException("Initialized with an empty board");
        }

        if (board.length == 0 || board[0].length == 0) {
            throw new IllegalStateException("Invalid board size");
        }

        rows = board.length;
        cols = board[0].length;

        this.board = BoardConverter.convertCellStatusBoardToCellBoard(board);
    }

    public CellStatus[][] next() {
        Cell[][] tempNewBoard = new Cell[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int numberOfAliveNeighbours = NeighbourStatusFinder.getNumberOfAliveNeighbours(row, col, board);
                tempNewBoard[row][col] = board[row][col].next(numberOfAliveNeighbours);
            }
        }

        board = tempNewBoard;

        return BoardConverter.convertCellBoardToCellStatusBoard(board);
    }
}
