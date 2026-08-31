package org.example.ChessGame.exception.boardExceptions;

public class CellOutOfBoundException extends Exception {
    public CellOutOfBoundException() {
        super("CellOutOfBoundException: Please select a valid cell index.");
    }

    public CellOutOfBoundException(String message) {
        super("CellOutOfBoundException: " + message);
    }
}
