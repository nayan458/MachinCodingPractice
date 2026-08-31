package org.example.ChessGame.service;

import java.util.Scanner;

import org.example.ChessGame.exception.generals.InvalidGameException;
import org.example.ChessGame.model.game.Game;
import org.example.ChessGame.model.game.GameResult;
import org.example.ChessGame.type.GameStatus;

public class GameService {

    public void startGame(Game game) throws Exception {
        try {
            if(game.getStatus() != GameStatus.READY_TO_PLAY)
                throw new Exception("Please check that the game is not ended or initialized correctly.");
            game.setStatus(GameStatus.ON_PROGRESS);
        } catch (Exception e) {
            game.publishError(e.getMessage());
            throw e;
        }
    }

    public void makeMove(Game game) throws Exception {
        try {
            game.makeMove();
            game.displayBoard();
            game.evaluateBoardStatus();

            if(game.getStatus() == GameStatus.ON_PROGRESS)
                game.advanceTurn();
        } catch (Exception e) {
            game.publishError(e.getMessage());
            throw e;
        }
    }

    public void displayBoard(Game game) throws Exception {
        try {
            if(game.getStatus() != GameStatus.ON_PROGRESS)
                throw new InvalidGameException();
            game.displayBoard();
        } catch (Exception e) {
            game.publishError(e.getMessage());
            throw e;
        }
    }

    public void displayStatus(Game game) throws Exception {
        try {
            if(game.getStatus() != GameStatus.ON_PROGRESS && game.getStatus() != GameStatus.ENDED)
                throw new InvalidGameException();
            System.out.println(game.getStatus());
        } catch (Exception e) {
            game.publishError(e.getMessage());
            throw e;
        }
    }

    public GameStatus getStatus (Game game) { return game.getStatus(); }

    public GameResult getResult (Game game) throws Exception {
        try {
            if(game.getStatus() != GameStatus.ENDED)
                throw new InvalidGameException();
            return game.getResult();
        } catch (Exception e) {
            game.publishError(e.getMessage());
            throw e;
        }
    }

    public void viewReplay (Game game) throws Exception {
        try {
            if(game.getStatus() != GameStatus.ENDED)
                throw new InvalidGameException();

            System.out.println("Do you want to view replay? type (Y) for yes.");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if(input.equals("Y"))
                game.viewReplay();

            sc.close();
        } catch (Exception e) {
            game.publishError(e.getMessage());
            throw e;
        }
    }

    public String promptAction(Game game) throws Exception {
        try {
            if(game.getStatus() != GameStatus.ON_PROGRESS)
                throw new InvalidGameException();
            return game.promptAction();
        } catch (Exception e) {
            game.publishError(e.getMessage());
            throw e;
        }
    }

    public void undo(Game game) throws Exception {
        try {
            if(game.getStatus() != GameStatus.ON_PROGRESS)
                throw new InvalidGameException();
            if(!game.canUndo())
                throw new Exception("No move available to undo.");
            game.undo();
        } catch (Exception e) {
            game.publishError(e.getMessage());
            throw e;
        }
    }

    public void resign(Game game) throws Exception {
        try {
            if(game.getStatus() != GameStatus.ON_PROGRESS)
                throw new InvalidGameException();
            game.resign();
        } catch (Exception e) {
            game.publishError(e.getMessage());
            throw e;
        }
    }

}
