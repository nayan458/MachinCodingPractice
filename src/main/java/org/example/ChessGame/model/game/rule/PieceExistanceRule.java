package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.GameContext;

public class PieceExistanceRule extends Rule {
    @Override
    protected void validate(GameContext ctx, Board board) throws RuleViolationException {
        if(ctx.getFrom().getPiece() == null)
            throw new RuleViolationException("Cannot select a empty cell");
        System.out.println("Validator: Piece Existance check rule triggered");
    }
}
