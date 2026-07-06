package org.example.TicTacToe.Strategies.WinningStrategies;

import org.example.TicTacToe.type.WinningStrategyType;

public class WinningStartegyFactory {
    
    public WinningStrategy createWiningStrategy(WinningStrategyType strategy) throws IllegalArgumentException {
        switch (strategy) {
            case HORIZENTAL : return new HorizentalWinningStrategy();
            case VERTICAL: return new VertivalWinningStartegy();
            case DIAGONAL: return new DiagonalWinningStrategy();
            default:
                throw new IllegalArgumentException("No such winning strategy exist");
        }
    }
}
