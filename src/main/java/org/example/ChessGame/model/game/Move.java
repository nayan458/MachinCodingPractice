package org.example.ChessGame.model.game;

import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.model.piece.Piece;
import org.example.ChessGame.model.player.Player;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Move {
    private Player player;
    private Piece piece;
    private Cell from;
    private Cell to;
    private String move;

    @Override
    public String toString(){
        return "Player " + player.getName() + " made a move: " + move ;
        // return Player.getColor() + Player.getName() + " moved " + Piece.getType() ;
    }
}
