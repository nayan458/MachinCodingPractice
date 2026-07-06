package org.example.TicTacToe.controller;

import org.example.TicTacToe.Exceptions.GameUnplayableException;
import org.example.TicTacToe.Exceptions.UndoEmptyListException;
import org.example.TicTacToe.model.Game;
import org.example.TicTacToe.model.Player;
import org.example.TicTacToe.service.GameService;
import org.example.TicTacToe.type.GameStatus;

public class Gamecontroller {
    
    private final GameService gameService;

    public Gamecontroller(GameService gameService) { 
        this.gameService = gameService;
    }

    public Player getNextPlayer(Game game) throws GameUnplayableException{
        return gameService.getNextPlayer(game);
    }

    public void makeMove(Game game) throws GameUnplayableException {
        gameService.makeMove(game);
    }

    public Player getWinner(Game game) throws Exception {
        return gameService.getWinner(game);
    }

    public void displayBoard(Game game) { gameService.displayBoard(game); }
    public boolean isBotEnable(Game game){ return gameService.isBotEnable(game); } 
    public GameStatus getStatus(Game game) { return gameService.getStatus(game); }
    public Game undo() throws UndoEmptyListException { return gameService.undo(); }
    


}
