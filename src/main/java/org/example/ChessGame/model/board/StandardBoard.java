package org.example.ChessGame.model.board;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.factory.PieceFactory;
import org.example.ChessGame.type.CellType;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.PieceType;

public class StandardBoard extends Board {
    public StandardBoard() {
        List<Cell> cells = new ArrayList<>();
        try {
            // create all the cells
            for(int rank = 0; rank < 8; rank++){
                CellType type = rank % 2 == 0 ? CellType.LIGHT_SQUARE : CellType.DARK_SQUARE;
                for(int file = 0; file < 8; file++) {
                    cells.add(new Cell(null, type, rank, file));
                    type = (type == CellType.LIGHT_SQUARE ? CellType.DARK_SQUARE : CellType.LIGHT_SQUARE);
                }
            }
    
            // assign pieces
            // ==== Pawns ====
            for(int i = 8; i < 16; i++)
                cells.get(i).setPiece( PieceFactory.create(PieceType.PAWN, Color.WHITE, cells.get(i)));
    
            for(int i = 48; i < 56; i++)
                cells.get(i).setPiece( PieceFactory.create(PieceType.PAWN, Color.BLACK, cells.get(i)));
    
            // ==== Rooks ====
            cells.get(0).setPiece( PieceFactory.create(PieceType.ROOK, Color.WHITE, cells.get(0)));
            cells.get(7).setPiece( PieceFactory.create(PieceType.ROOK, Color.WHITE, cells.get(7)));
    
            cells.get(57).setPiece( PieceFactory.create(PieceType.ROOK, Color.BLACK, cells.get(57)));
            cells.get(63).setPiece( PieceFactory.create(PieceType.ROOK, Color.BLACK, cells.get(63)));
    
            // ==== Knights ====
            cells.get(1).setPiece( PieceFactory.create(PieceType.KNIGHT, Color.WHITE, cells.get(1)));
            cells.get(6).setPiece( PieceFactory.create(PieceType.KNIGHT, Color.WHITE, cells.get(6)));
    
            cells.get(57).setPiece( PieceFactory.create(PieceType.KNIGHT, Color.BLACK, cells.get(57)));
            cells.get(62).setPiece( PieceFactory.create(PieceType.KNIGHT, Color.BLACK, cells.get(62)));
    
            // ==== Bishops ====
            cells.get(2).setPiece( PieceFactory.create(PieceType.BISHOP, Color.WHITE, cells.get(2)));
            cells.get(5).setPiece( PieceFactory.create(PieceType.BISHOP, Color.WHITE, cells.get(5)));
    
            cells.get(58).setPiece( PieceFactory.create(PieceType.BISHOP, Color.BLACK, cells.get(58)));
            cells.get(61).setPiece( PieceFactory.create(PieceType.BISHOP, Color.BLACK, cells.get(61)));
    
            // ==== Kings ====
            cells.get(3).setPiece( PieceFactory.create(PieceType.KING, Color.WHITE, cells.get(3)));
    
            cells.get(59).setPiece( PieceFactory.create(PieceType.KING, Color.BLACK, cells.get(59)));
            // ==== Queens ====
            cells.get(4).setPiece( PieceFactory.create(PieceType.QUEEN, Color.WHITE, cells.get(4)));
    
            cells.get(60).setPiece( PieceFactory.create(PieceType.QUEEN, Color.BLACK, cells.get(60)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

