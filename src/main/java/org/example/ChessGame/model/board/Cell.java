package org.example.ChessGame.model.board;

import org.example.ChessGame.model.piece.Piece;
import org.example.ChessGame.type.CellType;
import org.example.genericUtils.interfaces.Clonable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Cell implements Clonable<Cell> {
    private Piece piece;
    private final CellType type;  // Dark square or Light square
    private final Integer rank;   // row
    private final Integer file;   // col

    // public Cell(Piece piece){}

    // @Override
    // public Cell cloneObject() {
    //     return new Cell(piece.cloneObject(), type, rank, file);
    // }

    @Override
    public Cell cloneObject() {
        Piece clonedPiece = null;

        if (piece != null) {
            clonedPiece = piece.cloneObject();
        }

        return new Cell(clonedPiece, type, rank, file);
    }

    public void setPiece(Piece piece) { this.piece = piece; }

    public String display() {   // metod to visualize what piece seats on this cell
        return piece == null ? "==" : piece.display();
    }

    public void clear() {
        this.piece = null;
    }

    public Piece getPiece() { return this.piece; }

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
