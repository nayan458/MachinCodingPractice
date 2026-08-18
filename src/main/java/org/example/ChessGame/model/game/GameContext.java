package org.example.ChessGame.model.game;

import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.model.piece.Piece;
import org.example.ChessGame.model.player.Player;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameContext {
    private Player player;
    private Piece piece;
    private Cell from;
    private Cell to;

    @Override
    public String toString(){
        return "Player moved x from to";
        // return Player.getColor() + Player.getName() + " moved " + Piece.getType() ;
    }
}
