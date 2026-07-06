package org.example.TicTacToe.Exceptions;

public class RedoException extends Exception {
    public RedoException() {
        super("No valid redo operation is allowed");
    }

    public RedoException(String message) {
        super(message);
    }
}
