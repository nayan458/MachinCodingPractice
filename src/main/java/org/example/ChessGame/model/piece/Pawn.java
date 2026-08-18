package org.example.ChessGame.model.piece;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.PieceType;

public class Pawn extends Piece {

    public Pawn(Color color, Cell cell) {
        super(PieceType.PAWN, color, null);
    }

    @Override
    public List<Cell> getValidPositions(Cell from, Board board) {
        // TODO Auto-generated method stub
        return null;
    }


    public String display(){ return "P";}
}
