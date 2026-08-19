package org.example.ChessGame.model.game;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.events.EventBus;
import org.example.ChessGame.model.game.gameEvents.GameEvent;
import org.example.ChessGame.model.game.gameEvents.MoveEvent;
import org.example.ChessGame.model.player.Player;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.GameStatus;

public class Game {
    private final Board board;
    private final List<Player> players;
    private final RuleValidator ruleValidator;
    private final EventBus eventBus;
    private Player winner;
    private GameStatus status;
    private Integer currentPlayerIndex;
    private Scanner sc;
    // turn manager - (White moes first)
    // history

    private Game(GameBuilder gameBuilder) {
        this.status = GameStatus.INITIALIZING;
        this.board = gameBuilder.board;
        this.players = gameBuilder.players;
        this.ruleValidator = gameBuilder.ruleValidator;
        this.eventBus = gameBuilder.eventBus;
        this.currentPlayerIndex = 0;
        this.sc = new Scanner(System.in);
        Collections.shuffle(players);
        players.get(0).setColor(Color.WHITE);
        players.get(1).setColor(Color.BLACK);
        this.status = GameStatus.ON_PROGRESS;
    }

    public void displayBoard() {
        System.out.println(board);
    }

    public void start() {
        eventBus.publish(new GameEvent("WHITE TO MOVE: " + players.get(currentPlayerIndex).getName() + "'s turn") );
    }

    public void makeMove(){  // make a move
        String move = sc.nextLine();
        if(move.equals("regine")) {
            status = GameStatus.ENDED;
            int winnerIndex = (currentPlayerIndex + 1) % 2;
            winner = players.get(winnerIndex);
            eventBus.publish(new GameEvent(players.get(currentPlayerIndex).getName() + "Regined and the winner is, " + winner.getName()));
            return;
        }
        eventBus.publish(new MoveEvent(new Move(players.get(currentPlayerIndex), null, null, null, move)));
    }

    public void advanceTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
        eventBus.publish(new GameEvent("WHITE TO MOVE: " + players.get(currentPlayerIndex).getName() + "'s turn") );
    }

    public GameStatus getStatus(){ return this.status; }

    public void getListOfValidMove(String position){    // display list of moves for a selected position
        
    }

    public static class GameBuilder {
        private Board board;
        private List<Player> players;
        private RuleValidator ruleValidator;
        private EventBus eventBus;

        public GameBuilder setBoard(Board board){ this.board = board; return this;}
        public GameBuilder setPlayers(List<Player> players) throws Exception { if(players.size() != 2) throw new Exception("Exactly 2 players can play the game"); this.players = players; return this;}
        public GameBuilder setRuleValidator(RuleValidator ruleValidator){ this.ruleValidator = ruleValidator; return this; }
        public GameBuilder setEventBus(EventBus eventBus) { this.eventBus = eventBus; return this; }

        public Game build(){
            return new Game(this);
        }
    }
}
