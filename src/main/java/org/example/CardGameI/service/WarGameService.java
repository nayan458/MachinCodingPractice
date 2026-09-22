package org.example.CardGameI.service;

import org.example.CardGameI.model.game.CardGame;
import org.example.CardGameI.model.game.war.WarGame;
import org.example.CardGameI.type.GameStatus;

public class WarGameService extends GameService {

    @Override 
    public void start(CardGame game) throws Exception {
        if(game.getStatus() == GameStatus.NOT_STARTED)
            game.start();
        else
            throw new Exception("Game is already in: " + game.getStatus() + " state");
    }
    
    @Override
    public boolean isEnded(CardGame game) {
        return game.getStatus() == GameStatus.COMPLETED;
    }
    
    @Override
    public void playGame(CardGame game) throws Exception {
        game.makeMove();                    // Deal cards
        game.evaluate(); // Evaluate
        
        game.gameStateTransition();
        
        game.evaluateGameState();           // Check eliminations
        game.nextRound();                   // Record history
        
        displayTable(game);
    }
    
    @Override
    public void displayTable(CardGame game) throws Exception {
        WarGame warGame = (WarGame) game;
        System.out.println("\n=== War Game - Current State ===");
        System.out.println("Current State: " + warGame.getStatus());
        System.out.println("Pot Size: " + warGame.getPotSize());
        // System.out.println(game.getState().getStateType().toString());
        System.out.println("\nPlayers:");
        for(var player : game.getPlayers()) {
            System.out.println("  " + player.getName() + ": " + player.getDeck().size() + " cards");
        }
    }
    
    @Override
    public void displayResult(CardGame game) throws Exception {
        System.out.println("\n🎉 Game Over!");
        if(game.getWinner() != null)
            System.out.println("Winner: " + game.getWinner().getName());
        else
            System.out.println("Tie");
    }
    
    @Override
    public void evaluate(CardGame game) throws Exception {
        // Not used in this flow (playGame handles it)
    }
}