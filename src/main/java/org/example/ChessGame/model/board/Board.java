package org.example.ChessGame.model.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.ChessGame.model.game.move.Move;
import org.example.ChessGame.type.Color;
import org.example.genericUtils.interfaces.Clonable;
import org.example.ChessGame.model.piece.King;
import org.example.ChessGame.model.piece.Piece;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Board implements Clonable<Board> {
    protected List<Cell> cells;

    @Override
    public String toString() {
        StringBuffer view = new StringBuffer();
        for(int i = 0; i < 64; i++){
            if(i % 8 == 0){
                view.append("\n");
                view.append(String.valueOf(i/8 + 1));
            }
            view.append(" " + cells.get(i).display() + " ");
        }

        view.append("\n  A_  B_  C_  D_  E_  F_  G_  H_ ");

        return view.toString();
    }

    public Cell getCell(int cellNumber) {
        // try {
            
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }
        return cells.get(cellNumber);
    }

    public void apply(Move move) {
        move.getTo().setPiece(move.getPiece());
        move.getFrom().clear();
    }

    public Cell findKing(Color colorToMove) {
        for(Cell cell: cells)
            if(
                cell.getPiece() != null
                && cell.getPiece().getColor() == colorToMove
                && cell.getPiece() instanceof King
            )
                return cell;
        return null;    //TODO: Should have thrown exception but keeping it simple for now
    }

    public Map<? extends Piece,? extends Cell> getListOPieces(Color color) {
        Map<Piece, Cell> pieces = new HashMap<>();
        for(Cell cell: cells)
            if(cell.getPiece() != null && cell.getPiece().getColor() == color)
                pieces.put(cell.getPiece(), cell);
        return pieces;
    }
}
