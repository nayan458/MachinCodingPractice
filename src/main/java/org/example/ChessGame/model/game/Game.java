package org.example.ChessGame.model.game;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.events.Event;
import org.example.ChessGame.model.player.Player;
import org.example.ChessGame.type.GameStatus;
import org.example.genericUtils.Observer.Observer;
import org.example.genericUtils.Observer.Subject;

public class Game implements Subject<Event> {
    private final Board board;
    private final List<Player> players;
    private final RuleValidator ruleValidator;
    private Player winner;
    private List<Observer<Event>> subscribers;
    private GameStatus status;
    // turn manager - (White moes first)
    // history

    private Game(GameBuilder gameBuilder) {
        this.status = GameStatus.INITIALIZING;
        this.board = gameBuilder.board;
        this.players = gameBuilder.players;
        this.ruleValidator = gameBuilder.ruleValidator;
        this.subscribers = new ArrayList<>();
        this.status = GameStatus.ON_PROGRESS;
    }

    @Override
    public void subscribe(Observer<Event> subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unSubscribe(Observer<Event> subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifyObserver(Event event) {
        for(Observer<Event> subscriber: subscribers)
            subscriber.update(event);
    }

    public void makeMove(String move){  // make a move

    }

    public GameStatus getStatus(){ return this.status; }

    public void getListOfValidMove(String position){    // display list of moves for a selected position

    }

    public static class GameBuilder {
        private Board board;
        private List<Player> players;
        private RuleValidator ruleValidator;

        public GameBuilder setBoard(Board board){ this.board = board; return this;}
        public GameBuilder setPlayers(List<Player> players) throws Exception { if(players.size() != 2) throw new Exception("Exactly 2 players can play the game"); this.players = players; return this;}
        public GameBuilder setRuleValidator(RuleValidator ruleValidator){ this.ruleValidator = ruleValidator; return this;}

        public Game build(){
            return new Game(this);
        }
    }
}
