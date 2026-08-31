package org.example.ChessGame.model.game.gameEvaluator;

import java.util.Map;
import java.util.Set;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.model.piece.Piece;
import org.example.ChessGame.type.Color;

public final class AttackDetector {
    
    public static boolean isAttacked(Cell kingCell, Color colorToMove, Board board) {
        Map<? extends Piece, ? extends Cell> piecesCellMap = board.getListOPieces(colorToMove);
        for (Map.Entry<? extends Piece, ? extends Cell> entry : piecesCellMap.entrySet()) {
            Piece piece = entry.getKey();
            Cell from = entry.getValue();
            Set<Cell> positions = piece.getValidPositions(from, board);
            if(positions.contains(kingCell))
                return true;
        }
        return false;
    }
}
