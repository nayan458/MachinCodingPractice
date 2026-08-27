package org.example.ChessGame.model.piece;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.strategy.movementStrategy.LMovementStrategy;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.PieceType;

public class Knight extends Piece {
    public Knight(Color color) {
        super(PieceType.KNIGHT, color, new ArrayList<>(List.of(new LMovementStrategy())));
    }

    public Knight(Knight other) {
        super(other);
    }

    @Override
    public Piece cloneObject() {
        return new Knight(this);
    }

    public String display(){ return getColor() == Color.BLACK ? "BK" : "WK";}
}
