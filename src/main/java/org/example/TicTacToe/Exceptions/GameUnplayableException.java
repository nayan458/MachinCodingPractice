package org.example.TicTacToe.Exceptions;

public class GameUnplayableException extends Exception {
    public GameUnplayableException(String message) {
        super(message);
    }
    public GameUnplayableException() {
        super("Game is either ended or is not ready to play");
    }
}
