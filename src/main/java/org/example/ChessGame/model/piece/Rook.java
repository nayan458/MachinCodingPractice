package org.example.ChessGame.model.piece;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.strategy.movementStrategy.HorizontalMovementStrategy;
import org.example.ChessGame.strategy.movementStrategy.VerticalMovementStrategy;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.PieceType;

public class Rook extends Piece {

    private boolean isMoved;

    public Rook(Rook other) {
        super(other);
        this.isMoved = other.isMoved;
    }

    @Override
    public Piece cloneObject() {
        return new Rook(this);
    }

    public Rook(Color color) {
        super(
            PieceType.ROOK, 
            color, 
            new ArrayList<>(
                List.of(
                    new HorizontalMovementStrategy(), 
                    new VerticalMovementStrategy()
                )
            )
        );
        this.isMoved = false;
    }

    public void setIsMoved(){ this.isMoved = true; }

    public boolean isMoved() { return this.isMoved; } 

    @Override
    public List<Cell> getValidPositions(Cell from, Board board) {
        // TODO Auto-generated method stub
        return null;
    }


    public String display(){ return getColor() == Color.BLACK ? "BR" : "WR";}
}
