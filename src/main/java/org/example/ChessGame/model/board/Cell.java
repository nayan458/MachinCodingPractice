package org.example.ChessGame.model.board;

import org.example.ChessGame.model.piece.Piece;
import org.example.ChessGame.type.CellType;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Cell {
    private Piece piece;
    private final CellType type;  // Dark square or Light square
    private final Integer rank;   // row
    private final Integer file;   // col

    public void setPiece(Piece piece) { this.piece = piece; }

    public String display() {   // metod to visualize what piece seats on this cell
        return piece == null ? "==" : piece.display();
    }

    @Override
    public String toString() {
        String col = String.valueOf((char) ('A' + file));
        return "Cell{" +
                "piece=" + piece +
                ", type=" + type +
                ", rank=" + rank +
                ", file=" + file +
                ", cellId='" + col + file + '\'' +
                '}';
    }
}
