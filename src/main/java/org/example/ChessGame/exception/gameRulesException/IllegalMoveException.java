package org.example.ChessGame.exception.gameRulesException;

public class IllegalMoveException extends Exception {
    public IllegalMoveException() {
        super("Illegal Move: " + "This is not a leagal move");
    }

    public IllegalMoveException(String message) {
        super("Illegal Move: " + message);
    }
}
