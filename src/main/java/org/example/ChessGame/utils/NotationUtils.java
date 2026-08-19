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

    public static int getIndex(int row, int col) {
        return row * 8 + col;
    }

    public static Cell resolve(Board board, String notation) {
        return board.getCell(getIndex(rank(notation), file(notation)));
    }
}