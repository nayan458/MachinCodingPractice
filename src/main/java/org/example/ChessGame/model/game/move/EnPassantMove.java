package org.example.ChessGame.model.game.move;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.GameContext;



public class EnPassantMove extends Move {
    public EnPassantMove (GameContext ctx) {
        super(ctx);
    }

    @Override
    public boolean isPatterLegal() {
        return true;
    }
    @Override
    public void apply(Board board) {
        
    }
}
