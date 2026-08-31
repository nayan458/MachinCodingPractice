package org.example.ChessGame.service;

import java.util.Scanner;

import org.example.ChessGame.exception.generals.InvalidGameException;
import org.example.ChessGame.model.game.Game;
import org.example.ChessGame.model.game.GameResult;
import org.example.ChessGame.type.GameStatus;

public class GameService {

    public void startGame(Game game) throws Exception {
        if(game.getStatus() != GameStatus.READY_TO_PLAY)
            throw new Exception("Please check that the game is not ended or initialized correctly.");
        game.setStatus(GameStatus.ON_PROGRESS);
    }
    
    public void makeMove(Game game) throws Exception {

            game.makeMove();
            game.displayBoard();
            game.evaluateBoardStatus();

            if(game.getStatus() == GameStatus.ON_PROGRESS)
                game.advanceTurn();

    }

    public void displayBoard(Game game) throws Exception {
        if(game.getStatus() != GameStatus.ON_PROGRESS)
            throw new InvalidGameException();
        game.displayBoard();
    }

    public void displayStatus(Game game) throws Exception {
        if(game.getStatus() != GameStatus.ON_PROGRESS)
            throw new InvalidGameException();
        System.out.println(game.getStatus());
    }

    public GameStatus getStatus (Game game) { return game.getStatus(); }

    public GameResult getResult (Game game) throws Exception {
        if(game.getStatus() != GameStatus.ENDED)
            throw new InvalidGameException();
        return game.getResult();
    }

    public void viewReplay (Game game) throws Exception {
        if(game.getStatus() != GameStatus.ENDED)
            throw new InvalidGameException();

        System.out.println("Do you want to view replay? type (Y) for yes.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if(input.equals("Y"))
            game.viewReplay();

        sc.close();
    }

    public void undo(Game game) {
        game.undo();
    }

    public void resign(Game game) {
        game.resign();
    }

}
