package org.example.ChessGame.model.piece;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.strategy.movementStrategy.OneStepMovementStrategy;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.PieceType;

public class King extends Piece {
    private boolean isMoved;

    public King(Color color) {
        super(PieceType.KING, color, new ArrayList<>(List.of(new OneStepMovementStrategy())));
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

    @Override
    public List<Cell> getValidPositions(Cell from, Board board) {
        // TODO Auto-generated method stub
        return null;
    }

    public String display(){ return getColor() == Color.BLACK ? "B+" : "W+";}
}
