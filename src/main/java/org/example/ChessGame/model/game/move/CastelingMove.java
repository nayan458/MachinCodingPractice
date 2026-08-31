package org.example.ChessGame.model.game.move;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.GameContext;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.MoveType;
import org.example.ChessGame.utils.NotationUtils;

import lombok.Getter;


@Getter
public class CastelingMove extends Move {
    private MoveType side;

    public CastelingMove(GameContext ctx, MoveType side) {
        super(ctx);
        this.side = side;
    }

    @Override
    public boolean isPatterLegal(Board board) {
        // 2 step
        if(NotationUtils.checkDistance(NotationUtils.getIndex(from), NotationUtils.getIndex(to), board.getSize()) != 2) return false;
        // check rights
        switch (side) {
            case CASTELING_KING_SIDE:
                if(piece.getColor() == Color.BLACK)
                    return board.getBlackCastelingRights().isKingSideCastelingRight();
                if(piece.getColor() == Color.WHITE)
                    return board.getWhiteCastelingRights().isKingSideCastelingRight();

            case CASTELING_QUEEN_SIDE:
                if(piece.getColor() == Color.BLACK)
                    return board.getBlackCastelingRights().isQueenSideCastelingRight();
                if(piece.getColor() == Color.WHITE)
                    return board.getWhiteCastelingRights().isQueenSideCastelingRight();

            default:
                return false;
        }
    }
    @Override
    public void apply(Board board) {
        from.clear();
        to.setPiece(piece);
    }

}
