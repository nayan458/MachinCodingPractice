package org.example.ChessGame.exception.generals;

public class InvalidGameException extends Exception {
    public InvalidGameException() {
        super("INVALID GAME EXCEPTION: Please make sure the operation you want to achive is correct.");
    }

    public InvalidGameException (String message) {
        super("INVALID GAME EXCEPTION: " + message);
    }
}
