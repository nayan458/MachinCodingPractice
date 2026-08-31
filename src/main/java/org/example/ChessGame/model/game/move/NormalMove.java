package org.example.ChessGame.model.game.move;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.GameContext;
import org.example.ChessGame.type.PieceType;

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
        PieceType type = piece.getType();
        switch (type) {
            case KING -> {
                board.revokeCastelingRights(piece.getColor());
                break;
            }
            case ROOK -> {
                // if king side
                board.revokeKingSideCastelingRights(piece.getColor());
                // if queen side
                board.revokeQueenSideCastelingRights(piece.getColor());
                break;
            }
            default -> {    break; }
        }
        from.clear();
        to.setPiece(piece);
    }
}
