package org.example.ChessGame.model.game;

import java.util.List;
import java.util.Stack;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.move.Move;

public class GameHistory {
    private Stack<? extends Board> history;
    private List<? extends Move> moveHistory;
}
