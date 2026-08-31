package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.GameContext;

public abstract class Rule{

    private Rule nextRule;
    
    public void setNext(Rule nextRule) {
        this.nextRule = nextRule;
    }

    public void execute(GameContext ctx, Board board) throws Exception {
        validate(ctx, board);
        if(nextRule != null) {

            nextRule.execute(ctx, board);
        }
    }

    protected abstract void validate(GameContext ctx, Board board) throws Exception;
}
