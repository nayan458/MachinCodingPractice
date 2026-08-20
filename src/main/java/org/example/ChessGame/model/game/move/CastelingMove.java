package org.example.ChessGame.model.game.move;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.model.game.GameContext;
import org.example.ChessGame.type.MoveType;

import lombok.Getter;


@Getter
public class CastelingMove extends Move {
    private Cell rookFrom;
    private Cell rookTo;
    private MoveType type;

    public CastelingMove(GameContext ctx, MoveType type) {
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
