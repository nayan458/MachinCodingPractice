package org.example.ChessGame.model.piece;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.strategy.movementStrategy.DiagonalMovementStrategy;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.PieceType;

public class Bishop extends Piece{
    public Bishop(Color color, Cell cell) {
        super(PieceType.BISHOP, color, new ArrayList<>(List.of(new DiagonalMovementStrategy())));
    }

    @Override
    public List<Cell> getValidPositions(Cell from, Board board) {
        
        return null;
    }


    public String display(){ return "P";}
}
