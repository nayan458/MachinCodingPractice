package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.GameContext;

public class TurnCheckRule extends Rule {
    
    @Override
    protected void validate(GameContext ctx, Board board) throws RuleViolationException {
        
        System.out.println("Validator: Turn check rule triggered");
        if(ctx.getPlayer().getColor() != ctx.getPiece().getColor())
            throw new RuleViolationException("Validator:" + ctx.getPlayer().getColor().toString() + " turn to move.");
        System.out.println("Turn Check Rule: Passed ✅ ");
    }
}
