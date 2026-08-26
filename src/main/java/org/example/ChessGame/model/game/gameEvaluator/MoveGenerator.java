package org.example.ChessGame.model.game.gameEvaluator;

import java.util.Map;
import java.util.Set;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.model.piece.Piece;
import org.example.ChessGame.type.Color;

public class MoveGenerator {
    public boolean hasAnyLegalMove(Color color,Board board){ 
        Map<? extends Piece, ? extends Cell> piecesCellMap = board.getListOPieces(color);
        for (Map.Entry<? extends Piece, ? extends Cell> entry : piecesCellMap.entrySet()) {
            Piece piece = entry.getKey();
            Cell from = entry.getValue();
            Set<Cell> positions = piece.getValidPositions(from, board);
            if(positions.size() > 0)
                return true;
        }
        return false;
    }
}
