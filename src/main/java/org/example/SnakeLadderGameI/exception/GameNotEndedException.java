package org.example.SnakeLadderGameI.exception;

public class GameNotEndedException extends Exception {
    public GameNotEndedException() {
        super("Game not ended");
    }

    public GameNotEndedException(String message) {
        super(message);
    }
}
