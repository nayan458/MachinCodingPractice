package org.example.BattelShipGameI.model;

import org.example.BattelShipGameI.model.board.Board;

import lombok.AllArgsConstructor;

@AllArgsConstructor  
public class Move {
    private final Player attacker;
    private final Board attackedBoard;
    private final String move;    // cell position in comma seperated notation

    public Player getAttacker() { return this.attacker;}
    public Board getAttackedBoard() { return this.attackedBoard;}
    public String getMove() { return this.move;}

}
