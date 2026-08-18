package org.example.ChessGame.exception.gameRulesException;

public abstract class RuleViolationException extends Exception {
    
    public RuleViolationException() {
        super("GAME RULE VIOLATION: " + "This action is against the game rules");
    }

    public RuleViolationException(String message) {
        super("GAME RULE VIOLATION: " + message);
    }
}
