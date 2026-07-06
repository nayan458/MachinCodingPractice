package org.example.TicTacToe.Strategies.BotPlayingStrategies;

import org.example.TicTacToe.type.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public BotPlayingStrategy getBot(BotDifficultyLevel level) {
        switch (level) {
            case EASY: return new EasyBotPlayingStrategy();
            case MEDIUM: return new MediumBotPlayingStrategy();
            case HARD: return new HardBotPlayingStrategy();
            default:
                throw new IllegalArgumentException("No such bot exists");
        }
    }
}
