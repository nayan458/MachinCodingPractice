package org.example.ChessGame.strategy.movementStrategy;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.utils.NotationUtils;

public class KingMovementStrategy implements IMovementStrategy {

    private static final int[][] DIRECTIONS = {
        {1, 1},   {1, 0},   {1, -1},
        {0, 1},            {0, -1},
        {-1, 1},  {-1, 0}, {-1, -1}
    };

    @Override
    public List<Cell> getListOfMoves(Cell from, Board board) {

        List<Cell> moves = new ArrayList<>();

        int rank = from.getRank();
        int file = from.getFile();
        Color color = from.getPiece().getColor();

        for (int[] direction : DIRECTIONS) {

            int newRank = rank + direction[0];
            int newFile = file + direction[1];

            Cell cell = NotationUtils.resolve(board, newRank, newFile);

            if (isValid(cell, color)) {
                moves.add(cell);
            }
        }

        return moves;
    }

    @Override
    public boolean isValid(Cell cell, Color color) {

        if (cell == null) {
            return false;
        }

        return cell.getPiece() == null
                || cell.getPiece().getColor() != color;
    }
}