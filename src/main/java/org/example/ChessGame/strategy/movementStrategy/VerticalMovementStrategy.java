package org.example.ChessGame.strategy.movementStrategy;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.utils.NotationUtils;

public class VerticalMovementStrategy implements IMovementStrategy {
    
    private final static int[][] directions = {{1,1}, {1,-1}, {-1,-1}, {-1,1}};
    private Cell previous = null;
    private int file;

    @Override
    public List<Cell> getListOfMoves(Cell from, Board board) {
        List<Cell> to = new ArrayList<>();
        int rank = from.getRank();  // row
        int file = from.getFile();  // col

        this.file = file;
        
        for(int[] direction: directions) {
            int newRank = rank + direction[0];
            int newFile = file + direction[1];
            previous = null;

            Cell cell = NotationUtils.resolve(board, newRank, newFile);

            while(!isValid(cell, from.getPiece().getColor())) {
                to.add(cell);

                previous = cell;

                newRank = newRank + direction[0];
                newFile = newFile + direction[1];

                cell = NotationUtils.resolve(board, newRank, newFile);
            }
        }
        return to;
    }

    @Override
    public boolean isValid(Cell cell, Color color) {
        boolean valid = true;
        valid &= cell != null;
        valid &= (cell.getPiece() == null || cell.getPiece().getColor() != color);
        valid &= (previous == null || previous.getPiece() == null);
        valid &= cell.getFile() == this.file;   // check is in same file;
        return valid;
    }

}
