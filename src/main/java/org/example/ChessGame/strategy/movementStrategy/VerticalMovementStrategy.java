package org.example.ChessGame.strategy.movementStrategy;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;

public class VerticalMovementStrategy implements IMovementStrategy {
    
    public List<Cell> getListOfMoves(Cell from, Board board) {
        List<Cell> to = new ArrayList<>();
        return to;
    }

}
