package org.example.ChessGame.factory;

import org.example.ChessGame.exception.gameRulesException.IllegalMoveException;
import org.example.ChessGame.exception.pieceCreationException.IllegalPieceCreationException;
import org.example.ChessGame.model.game.GameContext;
import org.example.ChessGame.model.game.move.CastelingMove;
import org.example.ChessGame.model.game.move.EnPassantMove;
import org.example.ChessGame.model.game.move.Move;
import org.example.ChessGame.model.game.move.NormalMove;
import org.example.ChessGame.model.game.move.PromotionMove;
import org.example.ChessGame.type.MoveType;

public final class MoveFactory {
    public static Move getMove(MoveType type, GameContext ctx) throws IllegalMoveException {
        switch (type) {
            case NORMAL_MOVE: return new NormalMove(ctx);
            case ENPASSANT_MOVE: return new EnPassantMove(ctx);
            case PROMOTION_MOVE: 
                try {
                    return new PromotionMove(ctx);
                } catch (IllegalPieceCreationException e) {
                    throw new IllegalMoveException(e.getMessage());
                }
            case CASTELING_KING_SIDE: return new CastelingMove(ctx, MoveType.CASTELING_KING_SIDE);
            case CASTELING_QUEEN_SIDE: return new CastelingMove(ctx, MoveType.CASTELING_QUEEN_SIDE);
            
            default:
                throw new IllegalMoveException();
        }
    }
}
