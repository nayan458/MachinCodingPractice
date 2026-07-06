package org.example.TicTacToe.Strategies.BotPlayingStrategies;

import org.example.TicTacToe.Exceptions.IllegalMoveException;
import org.example.TicTacToe.model.Board;
import org.example.TicTacToe.model.Bot;
import org.example.TicTacToe.model.Move;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move makeMove(Board board, Bot bot) {
        int cellId = board.getEmptyCellId().get(0);
        int row = cellId/board.getSize() , col = cellId - (row * board.getSize());
        try {
            board.updateBoard(
                board.getCell(row, col), 
                bot.getSymbol(),
                bot);
            } catch (IllegalMoveException e) {
                System.out.println("Bot made a illegal move");
            }
        return new Move(board.getCell(row, col), bot);
    }

    
    
}
