package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.move.Move;

// check if the piece can really move the way user have provided the move in. Is there any obstacale etc.

public class PatternLeagalityRule extends Rule {
    @Override
    protected void validate(Move move, Board board) throws RuleViolationException {
        System.out.println("Validator: Pattern Legality check rule triggered");
        if(!move.isPatterLegal(board))
            throw new RuleViolationException("Illegal piece movement.");
        System.out.println("Pattern Legality Rule: Passed ✅ ");
    }
}
