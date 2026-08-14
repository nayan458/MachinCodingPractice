package org.example.SnakeLadderGameI.exception;

public class IllegalMoveException extends Exception {
    public IllegalMoveException() {
        super("Illegal Move");
    }

    public IllegalMoveException(String message) {
        super(message);
    }
}
