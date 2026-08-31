package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.exception.gameRulesException.IllegalMoveException;
import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.factory.MoveFactory;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.GameContext;
import org.example.ChessGame.model.game.move.Move;
import org.example.ChessGame.utils.MoveTypeEvaluator;

// check if the piece can really move the way user have provided the move in. Is there any obstacale etc.

public class PatternLeagalityRule extends Rule {
    @Override
    protected void validate(GameContext ctx, Board board) throws RuleViolationException, IllegalMoveException {
        System.out.println("Validator: Pattern Legality check rule triggered");
        Move dummMove = MoveFactory.getMove(MoveTypeEvaluator.evaluateMoveType(ctx),ctx);

        if(!dummMove.isPatterLegal(board))
            throw new RuleViolationException("Illegal piece movement.");
        System.out.println("Pattern Legality Rule: Passed ✅ ");
    }
}
