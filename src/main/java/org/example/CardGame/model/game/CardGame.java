package org.example.CardGame.model.game;

import java.util.List;

import org.example.CardGame.model.Player;
import org.example.CardGame.model.strategy.winningStrategies.IWinningStrategy;
import org.example.CardGame.type.GameStatusType;

public abstract class CardGame {
    private List<IWinningStrategy> winningStrategies;
    private GameStatusType status;

    public void distributeCards() {}
    public Player getWinner() {return null;}
    
    // protected check winning strategy
    
}
