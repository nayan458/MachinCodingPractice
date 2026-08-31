package org.example.ChessGame.model.game.gameEvaluator;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.TacticType;

public final class GameStatusEvaluator {

    public static TacticType evaluate(Board board, Color colorToMove) {
        Cell kingCell = board.findKing(colorToMove);
        boolean inCheck = AttackDetector.isAttacked(kingCell, opposite(colorToMove), board);
        boolean hasLegalMove = MoveGenerator.hasAnyLegalMove(colorToMove, board);

        if (inCheck && !hasLegalMove) return TacticType.CHECKMATE;
        if (!inCheck && !hasLegalMove) return TacticType.STALEMATE;
        if (inCheck) return TacticType.CHECK;
        return TacticType.NORMAL;
    }

    private static Color opposite(Color color){
        return color == Color.BLACK ? Color.WHITE : Color.BLACK;
    }
}
