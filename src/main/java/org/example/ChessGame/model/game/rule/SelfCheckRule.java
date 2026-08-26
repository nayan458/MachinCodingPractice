package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.GameContext;
import org.example.ChessGame.model.game.gameEvaluator.AttackDetector;

public class SelfCheckRule extends Rule {

    @Override
    protected void validate(GameContext ctx, Board board) throws RuleViolationException {
        AttackDetector attackDetector = new AttackDetector();
        if(attackDetector.isAttacked(board.findKing(ctx.getPlayer().getColor()), ctx.getPlayer().getColor(), board))
            throw new RuleViolationException("Illegal move, after the move your king is in check");
        System.out.println("Validator: Self check rule triggered");
    }
}
