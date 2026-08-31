package org.example.ChessGame.strategy.movementStrategy;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.utils.NotationUtils;

public class HorizontalMovementStrategy implements IMovementStrategy {
    
    private final static int[][] directions = {{0,1},{0,-1}};
    private Cell previousCell = null;
    private int rank;

    @Override
    public List<Cell> getListOfMoves(Cell from, Board board) {
        List<Cell> to = new ArrayList<>();
        int rank = from.getRank();  // row
        int file = from.getFile();  // col
        this.rank = rank;

        for(int[] direction: directions) {
            int newRank = rank + direction[0];
            int newFile = file + direction[1];

            Cell cell = NotationUtils.resolve(board, newRank, newFile);

            previousCell = null;

            while(isValid(cell, from.getPiece().getColor())) {
                to.add(cell);

                previousCell = cell;

                newRank = newRank + direction[0];
                newFile = newFile + direction[1];
                
                if(cell.getPiece() != null)
                    break;

                cell = NotationUtils.resolve(board, newRank, newFile);
            }
        }
        return to;
    }

    @Override
    public boolean isValid(Cell cell, Color color) {
        if (cell == null) {
            return false;
        }
        boolean valid = true;
        valid &= (cell.getPiece() == null || cell.getPiece().getColor() != color);  // no same color piece
        valid &= (previousCell == null || previousCell.getPiece() == null);
        valid &= cell.getRank() == rank;    // check for same rank
        return valid;
    }

}
