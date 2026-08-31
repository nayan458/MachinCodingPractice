package org.example.ChessGame.utils;

import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.model.game.GameContext;
import org.example.ChessGame.model.piece.Piece;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.MoveType;
import org.example.ChessGame.type.PieceType;

public final class MoveTypeEvaluator {
    public static MoveType evaluateMoveType(GameContext ctx) {
        Piece piece = ctx.getPiece();
        Cell from = ctx.getFrom();
        Cell to = ctx.getTo();

        if(piece == null)

        // Casteling enpausent promotion

        // King related moves
            // piece is king 
            // is moved 2 steps
            // King side or Queen Side
        if (piece.getType() == PieceType.KING) {
            int fileDelta = ctx.getTo().getFile() - ctx.getFrom().getFile();
            if (Math.abs(fileDelta) == 2) {
                return fileDelta > 0 ? MoveType.CASTELING_KING_SIDE : MoveType.CASTELING_QUEEN_SIDE;
            }
        }

        // Pawn related moves
        // ENPAUSSANT
        if(piece.getType() == PieceType.PAWN) {
            boolean diagonal = from.getFile() != to.getFile();
            boolean targetEmpty = to.getPiece() == null;
            if (diagonal && targetEmpty) {
                return MoveType.ENPASSANT_MOVE;   // candidate — not yet validated
            }
        }

        // PROMOTION
        if(piece.getType() == PieceType.PAWN) {
            if(piece.getColor() == Color.BLACK && to.getRank() == 0)
                return MoveType.PROMOTION_MOVE;
            if(piece.getColor() == Color.WHITE && to.getRank() == 7)
                return MoveType.PROMOTION_MOVE;
        }

        return MoveType.NORMAL_MOVE;
    }
}
