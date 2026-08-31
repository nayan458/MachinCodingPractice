package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.move.Move;

public abstract class Rule{

    private Rule nextRule;
    
    public void setNext(Rule nextRule) {
        this.nextRule = nextRule;
    }

    public void execute(Move move, Board board) throws RuleViolationException {
        validate(move, board);

        if(nextRule != null) {
            nextRule.execute(move, board);
        }
    }

    protected abstract void validate(Move move, Board board) throws RuleViolationException;
}
