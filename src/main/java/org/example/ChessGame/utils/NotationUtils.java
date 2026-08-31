package org.example.ChessGame.utils;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;

public final class NotationUtils {

    public static int getIndex(String notation) {
        int file = notation.charAt(0) - 'a';
        int rank = notation.charAt(1) - '1';

        return rank * 8 + file;
    }

    public static int file(String notation) {
        return notation.charAt(0) - 'a';
    }

    public static int rank(String notation) {
        return notation.charAt(1) - '1';
    }

    public static int getIndex(Cell cell) {
        return getIndex(cell.getRank(), cell.getFile());
    }

    public static int getIndex(int row, int col) {
        return row * 8 + col;
    }

    public static Cell resolve(Board board, String notation) {
        return board.getCell(getIndex(rank(notation), file(notation)));
    }

    public static Cell resolve(Board board, Integer row, Integer col) {
        try {
            return board.getCell(getIndex(row, col));
        } catch (Exception e) {     // index out of bound
            return null;
        }
    }

    public static int checkDistance(int from, int to, int sizeOfTheBoard) {
        int fromRow = from / sizeOfTheBoard;
        int fromCol = from % sizeOfTheBoard;

        int toRow = to / sizeOfTheBoard;
        int toCol = to % sizeOfTheBoard;

        return Math.max(
            Math.abs(fromRow - toRow),
            Math.abs(fromCol - toCol)
        );
    }
}