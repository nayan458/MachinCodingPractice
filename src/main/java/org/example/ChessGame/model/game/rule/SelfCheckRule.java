package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.gameEvaluator.AttackDetector;
import org.example.ChessGame.model.game.move.Move;

public class SelfCheckRule extends Rule {

    @Override
    protected void validate(Move move, Board board) throws RuleViolationException {
        System.out.println("Validator: Self check rule triggered");
        Board original = board.cloneObject();
        move.apply(board);
        if(AttackDetector.isAttacked(board.findKing(move.getPlayer().getColor()), move.getPlayer().getColor(), board)) {
            board = original;
            throw new RuleViolationException("Illegal move, after the move your king is in check");
        }
        board = original;
        System.out.println("Self check Rule: Passed ✅ ");
    }
}
