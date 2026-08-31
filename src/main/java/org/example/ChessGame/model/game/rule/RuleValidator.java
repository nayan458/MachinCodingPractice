package org.example.ChessGame.model.game.rule;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.GameContext;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RuleValidator {
    private final Rule rule;

    public void validate(GameContext ctx, Board board) throws Exception {
            rule.execute(ctx, board);
    }
}
