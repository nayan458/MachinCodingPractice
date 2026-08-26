package org.example.ChessGame.model.piece;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.strategy.movementStrategy.DiagonalMovementStrategy;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.PieceType;

public class Bishop extends Piece{
    public Bishop(Color color) {
        super(PieceType.BISHOP, color, new ArrayList<>(List.of(new DiagonalMovementStrategy())));
    }

    public Bishop(Bishop other) {
        super(other);
    }

    @Override
    public Piece cloneObject() {
        return new Bishop(this);
    }

    public String display(){ return getColor() == Color.BLACK ? "BB" : "WB";}
}
