package org.example.ChessGame.model.game.gameEvaluator;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.TacticType;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameStatusEvaluator {
    private final AttackDetector attackDetector;
    private final MoveGenerator moveGenerator; // generates all legal moves for a color

    public TacticType evaluate(Board board, Color colorToMove) {
        Cell kingCell = board.findKing(colorToMove);
        boolean inCheck = attackDetector.isAttacked(kingCell, opposite(colorToMove), board);
        boolean hasLegalMove = moveGenerator.hasAnyLegalMove(colorToMove, board);

        if (inCheck && !hasLegalMove) return TacticType.CHECKMATE;
        if (!inCheck && !hasLegalMove) return TacticType.STALEMATE;
        if (inCheck) return TacticType.CHECK;
        return TacticType.NORMAL;
    }

    public Color opposite(Color color){
        return color == Color.BLACK ? Color.WHITE : Color.BLACK;
    }
}
