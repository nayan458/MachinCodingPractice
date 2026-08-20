package org.example.ChessGame.model.game;

import java.util.List;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.model.game.move.Move;

public class RuleValidator {
    List<Rule> rules;

    public void validate(Move gameContext) throws RuleViolationException {
        for(Rule rule: rules)
            rule.validate(gameContext);
    }
}
