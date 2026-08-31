package org.example.ChessGame.model.game.move;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.GameContext;

public class NormalMove extends Move {
    public NormalMove (GameContext ctx) {
        super(ctx);
    }

    @Override
    public boolean isPatterLegal(Board board) {
        return piece.getValidPositions(from, board).contains(to);
    }
    @Override
    public void apply(Board board) {
        
    }
}
