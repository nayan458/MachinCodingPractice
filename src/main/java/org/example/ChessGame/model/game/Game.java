package org.example.ChessGame.model.game;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.events.IGameEvent;
import org.example.ChessGame.model.player.Player;
import org.example.genericUtils.Observer.Observer;
import org.example.genericUtils.Observer.Subject;

public class Game implements Subject<IGameEvent> {
    private final Board board;
    private final List<Player> players;
    private final RuleValidator ruleValidator;
    private Player winner;
    private List<Observer<IGameEvent>> subscribers;
    // turn manager - (White moes first)
    // history

    @Override
    public void subscribe(Observer<IGameEvent> subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unSubscribe(Observer<IGameEvent> subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifyObserver(IGameEvent event) {
        for(Observer<IGameEvent> subscriber: subscribers)
            subscriber.update(event);
    }

    private Game(GameBuilder gameBuilder) {
        this.board = gameBuilder.board;
        this.players = gameBuilder.players;
        this.ruleValidator = gameBuilder.ruleValidator;
        this.subscribers = new ArrayList<>();
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
