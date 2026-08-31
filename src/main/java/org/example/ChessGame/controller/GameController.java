package org.example.ChessGame.controller;

import org.example.ChessGame.model.game.Game;
import org.example.ChessGame.service.GameService;
import org.example.ChessGame.type.GameStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameController {
    private final GameService gameService;

    public void startGame(Game game) {

        try {
           gameService.startGame(game); 
           gameService.displayBoard(game);
        } catch (Exception e) {
            System.out.println("UNKNOWN EXCEPTION: " + e);
        }

    }

    public void makeMove(Game game) {
        try {
            gameService.makeMove(game);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }

    public void displayBoard(Game game) { 
        try {
            gameService.displayBoard(game);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayStatus(Game game) { 
        try {
            gameService.displayStatus(game);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public GameStatus getStatus (Game game) {
        return gameService.getStatus(game);
    }

    public void displayResult (Game game) {
        try {
            System.out.println(gameService.getResult(game));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewReplay (Game game) { 
        try {
            gameService.viewReplay(game);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
