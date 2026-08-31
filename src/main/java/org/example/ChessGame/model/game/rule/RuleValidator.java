package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.move.Move;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RuleValidator {
    private final Rule rule;

    public void validate(Move move, Board board) throws RuleViolationException {
            rule.execute(move, board);
    }
}
