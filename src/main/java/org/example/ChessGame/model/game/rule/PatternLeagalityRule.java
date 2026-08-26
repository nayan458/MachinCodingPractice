package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.GameContext;

// check if the piece can really move the way user have provided the move in. Is there any obstacale etc.

public class PatternLeagalityRule extends Rule {
    @Override
    protected void validate(GameContext ctx, Board board) throws RuleViolationException {
        if(!ctx.getPiece().getValidPositions(null, board).contains(ctx.getTo()))
            throw new RuleViolationException("Illegal piece movement.");
        System.out.println("Validator: Pattern Legality check rule triggered");
    }
}
