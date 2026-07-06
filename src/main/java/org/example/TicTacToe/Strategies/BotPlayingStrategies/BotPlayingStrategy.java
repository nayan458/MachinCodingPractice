package org.example.TicTacToe.Strategies.BotPlayingStrategies;

import org.example.TicTacToe.model.Board;
import org.example.TicTacToe.model.Bot;
import org.example.TicTacToe.model.Move;

public interface  BotPlayingStrategy {
    Move makeMove(Board board, Bot bot);
}
