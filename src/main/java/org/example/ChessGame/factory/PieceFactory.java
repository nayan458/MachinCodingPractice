package org.example.ChessGame.factory;

import org.example.ChessGame.exception.pieceCreationException.IllegalPieceCreationException;
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

    public static Piece create(PieceType type, Color color) throws IllegalPieceCreationException {
        switch (type) {
            case PAWN:
                return new Pawn(color);
            case KNIGHT:
                return new Knight(color);
            case BISHOP:
                return new Bishop(color);
            case ROOK:
                return new Rook(color);
            case KING:
                return new King(color);
            case QUEEN:
                return new Queen(color);
            default:
                throw new IllegalPieceCreationException();
        }
    }

    public static PieceType pieceTypeResolver(String ch) throws IllegalPieceCreationException {

        switch (ch) {
            case "P": return PieceType.PAWN;
            case "N": return PieceType.KNIGHT;
            case "B": return PieceType.BISHOP;
            case "R": return PieceType.ROOK;
            case "Q": return PieceType.QUEEN;
            default:
                throw new IllegalPieceCreationException();
        }
    }
}
