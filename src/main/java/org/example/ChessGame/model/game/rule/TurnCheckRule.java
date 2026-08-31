package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.move.Move;

public class TurnCheckRule extends Rule {
    
    @Override
    protected void validate(Move move, Board board) throws RuleViolationException {
        
        System.out.println("Validator: Turn check rule triggered");
        
        if(move.getPlayer().getColor() != move.getPiece().getColor())
            throw new RuleViolationException("Validator:" + move.getPlayer().getColor().toString() + " turn to move.");
    }
}
