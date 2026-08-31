package org.example.ChessGame.strategy.movementStrategy;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.utils.NotationUtils;

public class LMovementStrategy implements IMovementStrategy {

    private final static int[][] directions = {{2,1}, {2,-1}, {-2,1}, {-2,-1}, {-1,-2}, {-1,2}, {1,-2}, {1,2}};

    @Override
    public List<Cell> getListOfMoves(Cell from, Board board) {
        List<Cell> to = new ArrayList<>();
        int rank = from.getRank();  // row
        int file = from.getFile();  // col
        for(int[] direction: directions) {
            int newRank = rank + direction[0];
            int newFile = file + direction[1];

            Cell cell = NotationUtils.resolve(board, newRank, newFile);
            if(isValid(cell, from.getPiece().getColor()))
                to.add(cell);
        }
        return to;
    }

    @Override
    public boolean isValid(Cell cell, Color color) {
        if (cell == null) {
            return false;
        }
        boolean valid = true;
        valid &= (cell.getPiece() == null || cell.getPiece().getColor() != color);
        return valid;
    }
}