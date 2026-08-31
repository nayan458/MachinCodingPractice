package org.example.ChessGame.controller;

import org.example.ChessGame.exception.gameRulesException.IllegalMoveException;
import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
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
        } catch (IllegalMoveException e) {
            System.out.println(e.getMessage());
        } catch (RuleViolationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("UNKNOWN EXCEPTION: " + e.getMessage());
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

    public void viewReplay (Game game) { 
        try {
            gameService.viewReplay(game);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
