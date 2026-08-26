package org.example.ChessGame.model.piece;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.strategy.movementStrategy.PawnMovementStrategy;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.PieceType;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(PieceType.PAWN, color, new ArrayList<>(List.of(new PawnMovementStrategy())));
    }

    public Pawn(Pawn other) {
        super(other);
    }

    @Override
    public Piece cloneObject() {
        return new Pawn(this);
    }

    public String display(){ return getColor() == Color.BLACK ? "BP" : "WP";}
}
