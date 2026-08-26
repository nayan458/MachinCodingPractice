package org.example.ChessGame.model.piece;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.strategy.movementStrategy.DiagonalMovementStrategy;
import org.example.ChessGame.strategy.movementStrategy.HorizontalMovementStrategy;
import org.example.ChessGame.strategy.movementStrategy.IMovementStrategy;
import org.example.ChessGame.strategy.movementStrategy.VerticalMovementStrategy;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.PieceType;

public class Queen extends Piece {
    public Queen(Color color) {
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
    public Set<Cell> getValidPositions(Cell from, Board board) {
        Set<Cell> validPositions = new HashSet<>();
        for(IMovementStrategy movementStrategie: movementStrategies)
            validPositions.addAll(movementStrategie.getListOfMoves(from, board));
        return validPositions;
    }


    public String display(){ return getColor() == Color.BLACK ? "BQ" : "WQ";}
}
