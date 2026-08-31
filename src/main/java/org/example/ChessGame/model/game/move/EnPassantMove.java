package org.example.ChessGame.model.game.move;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.GameContext;
import org.example.ChessGame.type.PieceType;


public class EnPassantMove extends Move {

    private final Move previous;
    
    public EnPassantMove (GameContext ctx) {
        super(ctx);
        this.previous = ctx.getPrevious();
    }

    @Override
    public boolean isPatterLegal(Board board) {
        if (!(previous instanceof NormalMove)) return false;
        if (previous.getPiece().getType() != PieceType.PAWN) return false;
        if (Math.abs(previous.getFrom().getRank() - previous.getTo().getRank()) != 2) return false;
        if (previous.getTo().getFile() != getTo().getFile()) return false;
        if (previous.getTo().getRank() != getFrom().getRank()) return false;
        return true;
    }
    @Override
    public void apply(Board board) {
        
    }
}
