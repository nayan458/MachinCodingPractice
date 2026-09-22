package org.example.CardGameI.service;

import org.example.CardGameI.model.game.CardGame;

public abstract class GameService {
    public abstract void start(CardGame game) throws Exception;
    public abstract boolean isEnded(CardGame game);
    public abstract void playGame(CardGame game) throws Exception;
    public abstract void evaluate(CardGame game) throws Exception;
    public abstract void displayTable(CardGame game) throws Exception;
    public abstract void displayResult(CardGame game) throws Exception;
}
