package org.example.SnakeLadderGameI.service;

import org.example.SnakeLadderGameI.abstractModel.Player;
import org.example.SnakeLadderGameI.exception.GameNotEndedException;
import org.example.SnakeLadderGameI.model.Game;
import org.example.SnakeLadderGameI.model.Move;
import org.example.SnakeLadderGameI.type.GameStatus;

public class GameService {

    public Player getNextPlayer(Game game) { return game.getNextPlayer(); }

    public void makeMove(Game game) {
        Move move = game.getNextPlayer().makeMove(game.getDice());
        game.makeMove(move);
        game.advanceTurn();
    }

    public Player getWinner(Game game) throws GameNotEndedException { return game.getWinner(); }

    public void displayBoard(Game game) { game.displayBoard(); }

    public GameStatus getGameStatus(Game game) { return game.getGameStatus(); }

}
