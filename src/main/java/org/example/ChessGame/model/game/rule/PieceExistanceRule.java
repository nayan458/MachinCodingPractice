package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.move.Move;

public class PieceExistanceRule extends Rule {
    @Override
    protected void validate(Move move, Board board) throws RuleViolationException {
        if(move.getFrom().getPiece() == null)
            throw new RuleViolationException("Cannot select a empty cell");
        System.out.println("Validator: Piece Existance check rule triggered");
    }
}
