package org.example.TicTacToe.Strategies.WinningStrategies;

import org.example.TicTacToe.model.Board;

public interface  WinningStrategy {
    boolean checkWin(Board board);
}
