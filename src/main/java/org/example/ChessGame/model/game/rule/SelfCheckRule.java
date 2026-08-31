package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.exception.gameRulesException.IllegalMoveException;
import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.factory.MoveFactory;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.GameContext;
import org.example.ChessGame.model.game.gameEvaluator.AttackDetector;
import org.example.ChessGame.model.game.move.Move;
import org.example.ChessGame.utils.MoveTypeEvaluator;

public class SelfCheckRule extends Rule {

    @Override
    protected void validate(GameContext ctx, Board board) throws RuleViolationException, IllegalMoveException {
        System.out.println("Validator: Self check rule triggered");
        Board original = board.cloneObject();

        Move move = MoveFactory.getMove(MoveTypeEvaluator.evaluateMoveType(ctx),ctx);
        move.apply(board);
        if(AttackDetector.isAttacked(board.findKing(move.getPlayer().getColor()), move.getPlayer().getColor(), board)) {
            board = original;
            throw new RuleViolationException("Illegal move, after the move your king is in check");
        }
        board = original;
        System.out.println("Self check Rule: Passed ✅ ");
    }
}
