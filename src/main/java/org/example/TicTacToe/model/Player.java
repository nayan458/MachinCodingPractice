package org.example.TicTacToe.model;

import org.example.TicTacToe.type.PlayerType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class  Player{
    private final String name;
    private final PlayerType playerType;
    private final Symbol symbol;

    public abstract Move makeMove(Board board);
}