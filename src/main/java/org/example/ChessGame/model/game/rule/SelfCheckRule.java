package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.gameEvaluator.AttackDetector;
import org.example.ChessGame.model.game.move.Move;

public class SelfCheckRule extends Rule {

    @Override
    protected void validate(Move move, Board board) throws RuleViolationException {
        if(AttackDetector.isAttacked(board.findKing(move.getPlayer().getColor()), move.getPlayer().getColor(), board))
            throw new RuleViolationException("Illegal move, after the move your king is in check");
        System.out.println("Validator: Self check rule triggered");
    }
}
