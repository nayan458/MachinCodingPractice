package org.example.ChessGame.strategy.movementStrategy;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.utils.NotationUtils;

public class PawnMovementStrategy implements IMovementStrategy {

    private static final int[][] CAPTURE_DIRECTIONS = {
        {0, 1},
        {0, -1}
    };

    @Override
    public List<Cell> getListOfMoves(Cell from, Board board) {

        List<Cell> moves = new ArrayList<>();

        Color color = from.getPiece().getColor();

        int rank = from.getRank();
        int file = from.getFile();

        int direction = color == Color.WHITE ? 1 : -1;

        // 1. Forward one square
        Cell forward = NotationUtils.resolve(
                board,
                rank + direction,
                file
        );

        if (forward != null && forward.getPiece() == null) {
            moves.add(forward);

            // 2. Forward two squares
            if (isOnStartingRank(from, color)) {

                Cell doubleForward = NotationUtils.resolve(
                        board,
                        rank + (2 * direction),
                        file
                );

                if (doubleForward != null
                        && doubleForward.getPiece() == null) {
                    moves.add(doubleForward);
                }
            }
        }

        // 3. Diagonal captures
        for (int[] captureDirection : CAPTURE_DIRECTIONS) {

            int newRank = rank + direction;
            int newFile = file + captureDirection[1];

            Cell cell = NotationUtils.resolve(
                    board,
                    newRank,
                    newFile
            );

            if (canCapture(cell, color)) {
                moves.add(cell);
            }
        }

        return moves;
    }

    private boolean isOnStartingRank(Cell from, Color color) {

        // Change these according to your board representation.
        return color == Color.WHITE
                ? from.getRank() == 1
                : from.getRank() == 6;
    }

    private boolean canCapture(Cell cell, Color color) {

        if (cell == null || cell.getPiece() == null) {
            return false;
        }

        return cell.getPiece().getColor() != color;
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