package org.example.TicTacToe.model;

import org.example.TicTacToe.Strategies.BotPlayingStrategies.BotPlayingStrategy;
import org.example.TicTacToe.type.PlayerType;


public class Bot extends Player {
    private final BotPlayingStrategy botPlayingStrategy;
    
    public Bot(BotPlayingStrategy botPlayingStrategy){
        super("Jhon Doe", PlayerType.BOT, new Symbol("BOT"));
        this.botPlayingStrategy = botPlayingStrategy;
    }

    @Override
    public Move makeMove(Board board){
        return botPlayingStrategy.makeMove(board, this);
    }
}