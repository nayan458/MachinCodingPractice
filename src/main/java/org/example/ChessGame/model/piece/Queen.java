package org.example.ChessGame.model.piece;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.strategy.movementStrategy.DiagonalMovementStrategy;
import org.example.ChessGame.strategy.movementStrategy.HorizontalMovementStrategy;
import org.example.ChessGame.strategy.movementStrategy.VerticalMovementStrategy;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.PieceType;

public class Queen extends Piece {
    public Queen(Color color, Cell cell) {
        super(
            PieceType.QUEEN, 
            color, 
            new ArrayList<>(
                List.of(
                    new DiagonalMovementStrategy(), 
                    new HorizontalMovementStrategy(), 
                    new VerticalMovementStrategy()
                )
            )
        );
    }

    public Queen(Queen other) {
        super(other);
    }

    @Override
    public Piece cloneObject() {
        return new Queen(this);
    }

    @Override
    public List<Cell> getValidPositions(Cell from, Board board) {
        // TODO Auto-generated method stub
        return null;
    }


    public String display(){ return getColor() == Color.BLACK ? "BQ" : "WQ";}
}
