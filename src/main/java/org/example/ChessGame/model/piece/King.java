package org.example.ChessGame.model.piece;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.strategy.movementStrategy.KingMovementStrategy;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.PieceType;

public class King extends Piece {
    private boolean isMoved;

    public King(Color color) {
        super(PieceType.KING, color, new ArrayList<>(List.of(new KingMovementStrategy())));
    }

    public King(King other) {
        super(other);
    }

    public void setIsMoved() { isMoved = true;}

    public boolean getIsMoved() { return this.isMoved; }

    @Override
    public Piece cloneObject() {
        return new King(this);
    }

    public String display(){ return getColor() == Color.BLACK ? "B+" : "W+";}
}
