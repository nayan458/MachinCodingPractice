package org.example.TicTacToe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Move {
    private Cell cell;
    private Player player;
}