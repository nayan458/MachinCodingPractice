package org.example.ChessGame.model.game;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.model.game.move.Move;

public interface Rule {
    public void validate(Move gameContext) throws RuleViolationException;
}
