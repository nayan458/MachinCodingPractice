package org.example.ChessGame.factory;

import org.example.ChessGame.exception.pieceCreationException.IllegalPieceCreationException;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.model.piece.Bishop;
import org.example.ChessGame.model.piece.King;
import org.example.ChessGame.model.piece.Knight;
import org.example.ChessGame.model.piece.Pawn;
import org.example.ChessGame.model.piece.Piece;
import org.example.ChessGame.model.piece.Queen;
import org.example.ChessGame.model.piece.Rook;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.PieceType;

public final class PieceFactory {

    public static Piece create(PieceType type, Color color, Cell cell) throws IllegalPieceCreationException {
        switch (type) {
            case PAWN:
                return new Pawn(color, cell);
            case KNIGHT:
                return new Knight(color, cell);
            case BISHOP:
                return new Bishop(color, cell);
            case ROOK:
                return new Rook(color, cell);
            case KING:
                return new King(color, cell);
            case QUEEN:
                return new Queen(color, cell);
            default:
                throw new IllegalPieceCreationException();
        }
    }

}
