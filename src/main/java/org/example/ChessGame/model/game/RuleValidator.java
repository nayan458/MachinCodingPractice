package org.example.ChessGame.model.game;

import java.util.List;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;

public class RuleValidator {
    List<Rule> rules;

    public void validate(GameContext gameContext) throws RuleViolationException {
        for(Rule rule: rules)
            rule.validate(gameContext);

    }
}
