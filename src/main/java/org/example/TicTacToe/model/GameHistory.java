package org.example.TicTacToe.model;

import java.util.ArrayList;
import java.util.List;

import org.example.TicTacToe.Exceptions.UndoEmptyListException;

public class GameHistory {
    private final List<Game> history;

    public GameHistory(Game game) {
        this.history = new ArrayList<>();
        this.history.add(game.cloneObject());
    }

    public Game undo() throws UndoEmptyListException {
        if(history.size() <= 1)
            throw new UndoEmptyListException();
        history.remove(history.size() - 1);
        return history.get(history.size() - 1);
    }

    public void addCurrentGame(Game game) {
        history.add(game.cloneObject());
    }

}
