package org.example.ChessGame.model.game.move;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.model.game.GameContext;
import org.example.ChessGame.model.piece.Piece;
import org.example.ChessGame.model.player.Player;

import lombok.Getter;


@Getter
public abstract class Move {
    private final Player player;
    private final Piece piece;
    private final Cell from;
    private final Cell to;
    private final String move;
    private Piece CapturedPiece;

    public Move(GameContext ctx) {
        this.player = ctx.getPlayer();
        this.piece = ctx.getPiece();
        this.from = ctx.getFrom();
        this.to = ctx.getTo();
        this.move = ctx.getMove();
        this.CapturedPiece = null;
    }

    public void setCapturedPiece(Piece piece) { this.CapturedPiece = piece; }

    @Override
    public String toString(){
        return "Player " + player.getName() + " made a move: " + move ;
        // return Player.getColor() + Player.getName() + " moved " + Piece.getType() ;
    }

    public abstract boolean isPatterLegal();
    public abstract void apply(Board board);
}
