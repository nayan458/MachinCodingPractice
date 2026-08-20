package org.example.ChessGame.model.board;

import java.util.List;

import org.example.ChessGame.model.game.move.Move;
import org.example.genericUtils.interfaces.Clonable;

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
}
