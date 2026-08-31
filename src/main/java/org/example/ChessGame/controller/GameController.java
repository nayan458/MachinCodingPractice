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
            // already reported to players/logger via ErrorEvent
        }
    }

    public void makeMove(Game game) {
        try {
            gameService.makeMove(game);
        } catch (Exception e) {
            // already reported to players/logger via ErrorEvent
        }
    }

    public String promptAction(Game game) {
        try {
            return gameService.promptAction(game);
        } catch (Exception e) {
            return "";
        }
    }

    public void undo(Game game) {
        try {
            gameService.undo(game);
        } catch (Exception e) {
            // already reported to players/logger via ErrorEvent
        }
    }

    public void resign(Game game) {
        try {
            gameService.resign(game);
        } catch (Exception e) {
            // already reported to players/logger via ErrorEvent
        }
    }

    public void displayBoard(Game game) {
        try {
            gameService.displayBoard(game);
        } catch (Exception e) {
            // already reported to players/logger via ErrorEvent
        }
    }

    public void displayStatus(Game game) {
        try {
            gameService.displayStatus(game);
        } catch (Exception e) {
            // already reported to players/logger via ErrorEvent
        }
    }

    public GameStatus getStatus (Game game) {
        return gameService.getStatus(game);
    }

    public void displayResult (Game game) {
        try {
            System.out.println(gameService.getResult(game));
        } catch (Exception e) {
            // already reported to players/logger via ErrorEvent
        }
    }

    public void viewReplay (Game game) {
        try {
            gameService.viewReplay(game);
        } catch (Exception e) {
            // already reported to players/logger via ErrorEvent
        }
    }

}
