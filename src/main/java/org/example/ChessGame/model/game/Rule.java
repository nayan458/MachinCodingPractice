package org.example.ChessGame.model.game;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;

public interface Rule {
    public void validate(Move gameContext) throws RuleViolationException;
}
