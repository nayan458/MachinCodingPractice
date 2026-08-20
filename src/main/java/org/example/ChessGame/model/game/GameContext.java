package org.example.ChessGame.model.game;

import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.model.game.move.Move;
import org.example.ChessGame.model.piece.Piece;
import org.example.ChessGame.model.player.Player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class GameContext {
    private final Player player;
    private final Piece piece;
    private final Cell from;
    private final Cell to;
    private final String move;
    private final Move previous;
}
