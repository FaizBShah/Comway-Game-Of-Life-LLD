package org.example;

import org.junit.jupiter.api.Test;

import static org.example.CellCharacter.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void shouldGameObjectBeCreatedSuccessfully() {
        assertDoesNotThrow(Game::new);
    }

    @Test
    void shouldGameBeInitializedWithABoardSuccessFully() {
        Game game = new Game();
        CellCharacter[][] gameBoard = {
                { EMPTY, EMPTY, FILLED },
                { EMPTY, FILLED, EMPTY },
                { FILLED, FILLED, EMPTY }
        };

        assertDoesNotThrow(() -> game.startWithBoard(gameBoard));
        assertDoesNotThrow(game::stop);
    }

    @Test
    void shouldThrowAnErrorIfTryingToInitializeAGameOnceItHasAlreadyStarted() {
        Game game = new Game();
        CellCharacter[][] gameBoard = {
                { EMPTY, EMPTY, FILLED },
                { EMPTY, FILLED, EMPTY },
                { FILLED, FILLED, EMPTY }
        };

        game.startWithBoard(gameBoard);

        Throwable exception = assertThrows(IllegalStateException.class, () -> game.startWithBoard(gameBoard));

        assertEquals("Game has already been started with a board", exception.getMessage());
    }

    @Test
    void shouldThrowAnErrorIfTryingToInitializeTheGameWithAnEmptyNullBoard() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> new Game().startWithBoard(null));
        assertEquals("Initialized with an empty board", exception.getMessage());
    }

    @Test
    void shouldThrowAnErrorIfTryingToInitializeTheGameWithInvalidBoardDimensions() {
        CellCharacter[][] gameBoard = new CellCharacter[0][0];

        Throwable exception = assertThrows(IllegalStateException.class, () -> new Game().startWithBoard(gameBoard));

        assertEquals("Invalid board size", exception.getMessage());
    }

    @Test
    void shouldGameBeInitializedWithARandomBoardSuccessfully() {
        Game game = new Game();

        assertDoesNotThrow(() -> game.startWithRandomBoardOfSize(3, 3));
        assertDoesNotThrow(() -> game.tick());

        CellCharacter[][] board = game.tick();

        assertEquals(3, board.length);
        assertEquals(3, board[0].length);

        assertDoesNotThrow(game::stop);
    }

    @Test
    void shouldThrowAnErrorIfTryingToRandomInitializeAGameOnceItHasAlreadyStarted() {
        Game game = new Game();

        game.startWithRandomBoardOfSize(3, 3);

        Throwable exception = assertThrows(IllegalStateException.class, () -> game.startWithRandomBoardOfSize(3, 3));

        assertEquals("Game has already been started with a board", exception.getMessage());
    }

    @Test
    void shouldThrowAnErrorIfTryingToRandomInitializeAGameWithNegativeRowOrColumn() {
        Game game = new Game();

        Throwable exception1 = assertThrows(IllegalStateException.class, () -> game.startWithRandomBoardOfSize(-1, 3));
        Throwable exception2 = assertThrows(IllegalStateException.class, () -> game.startWithRandomBoardOfSize(3, -1));
        Throwable exception3 = assertThrows(IllegalStateException.class, () -> game.startWithRandomBoardOfSize(-1, -1));

        assertEquals("Dimensions of the board should be valid", exception1.getMessage());
        assertEquals("Dimensions of the board should be valid", exception2.getMessage());
        assertEquals("Dimensions of the board should be valid", exception3.getMessage());
    }

    @Test
    void shouldTickWorkCorrectly() {
        Game game = new Game();
        CellCharacter[][] gameBoard = {
                { EMPTY, EMPTY, FILLED },
                { EMPTY, FILLED, EMPTY },
                { FILLED, FILLED, EMPTY }
        };
        CellCharacter[][] expectedGameBoard = {
                { EMPTY, EMPTY, EMPTY },
                { FILLED, FILLED, FILLED },
                { FILLED, FILLED, EMPTY }
        };

        game.startWithBoard(gameBoard);
        CellCharacter[][] resultGameBoard = game.tick();

        assertEquals(expectedGameBoard.length, resultGameBoard.length);
        assertEquals(expectedGameBoard[0].length, resultGameBoard[0].length);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(expectedGameBoard[i][j], resultGameBoard[i][j]);
            }
        }
    }

    @Test
    void shouldThrowAnErrorIfTryingToCallTheTickFunctionWhenTheGameHasNotBeenInitializedWithABoard() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> new Game().tick());
        assertEquals("Game has not been initialized with a board yet", exception.getMessage());
    }

    @Test
    void shouldTickNTimesWorkCorrectly() {
        Game game = new Game();
        CellCharacter[][] gameBoard = {
                { EMPTY, EMPTY, FILLED },
                { EMPTY, FILLED, EMPTY },
                { FILLED, FILLED, EMPTY }
        };
        CellCharacter[][] expectedGameBoard = {
                { EMPTY, FILLED, EMPTY },
                { FILLED, EMPTY, FILLED },
                { FILLED, EMPTY, FILLED }
        };

        game.startWithBoard(gameBoard);
        CellCharacter[][] resultGameBoard = game.tick(2);

        assertEquals(expectedGameBoard.length, resultGameBoard.length);
        assertEquals(expectedGameBoard[0].length, resultGameBoard[0].length);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(expectedGameBoard[i][j], resultGameBoard[i][j]);
            }
        }
    }

    @Test
    void shouldThrowAnErrorIfTryingToCallTheTickNFunctionWhenTheGameHasNotBeenInitializedWithABoard() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> new Game().tick(5));
        assertEquals("Game has not been initialized with a board yet", exception.getMessage());
    }

    @Test
    void shouldStopFunctionWorkCorrectly() {
        Game game = new Game();

        game.startWithRandomBoardOfSize(4, 3);

        assertDoesNotThrow(game::stop);
    }

    @Test
    void shouldThrowAnErrorIfTryingToStopAGameWhichHasNotBeenInitialized() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> new Game().stop());
        assertEquals("There is no game currently being run that could be stopped", exception.getMessage());
    }

}