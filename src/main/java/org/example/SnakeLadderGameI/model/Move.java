package org.example.SnakeLadderGameI.model;

import org.example.SnakeLadderGameI.abstractModel.Player;
import org.example.TicTacToe.Exceptions.IllegalMoveException;

import lombok.Getter;

@Getter
public class Move {
    private Player player;
    private int diceValue;

    public Move (Player player, int diceValue) throws IllegalMoveException {
        if(diceValue < 0)
            throw new IllegalMoveException();
        this.player = player;
        this.diceValue = diceValue;
    }
}
