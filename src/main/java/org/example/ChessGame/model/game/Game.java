package org.example.ChessGame.model.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.events.EventBus;
import org.example.ChessGame.model.game.gameEvents.GameEvent;
import org.example.ChessGame.model.game.gameEvents.MoveEvent;
import org.example.ChessGame.model.game.move.Move;
import org.example.ChessGame.model.player.Player;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.GameStatus;
import org.example.ChessGame.utils.NotationUtils;

public class Game {
    private Board board;
    private final List<Player> players;
    private final RuleValidator ruleValidator;
    private final EventBus eventBus;
    private Player winner;
    private GameStatus status;
    private Integer currentPlayerIndex;
    private Scanner sc;
    private List<Board> history;
    private List<? extends Move> moveHistory;
    private Color currentColor;
    
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
        this.history = new ArrayList<>();
        this.history.add(board.cloneObject());
        this.moveHistory = new ArrayList<>();
        this.moveHistory.add(null);
        this.status = GameStatus.ON_PROGRESS;
    }

    public void displayBoard() {
        System.out.println(board);
    }

    public void start() {
        Color currentColor = players.get(currentPlayerIndex).getColor();
        eventBus.publish(new GameEvent(currentColor +" TO MOVE: " + players.get(currentPlayerIndex).getName() + "'s turn") );
    }

    public void undo() {
        history.remove(history.size()-1);
        this.board = history.get(history.size() - 1);
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
        System.out.println(board);
    }

    public void makeMove(){  // make a move
        Color currentColor = players.get(currentPlayerIndex).getColor();
        eventBus.publish(new GameEvent(currentColor + " TO MOVE: " + players.get(currentPlayerIndex).getName() + "'s turn"));
        System.out.println("Please select the position of the piece to move: ");
        System.out.println("Use U for undo and R to regine");
        String moveMade = sc.nextLine();

        if(moveMade.equals("U")) {
            undo();
            makeMove();
        }

        if(moveMade.equals("R")) {
            status = GameStatus.ENDED;
            int winnerIndex = (currentPlayerIndex + 1) % 2;
            winner = players.get(winnerIndex);
            eventBus.publish(new GameEvent(players.get(currentPlayerIndex).getName() + " Regined and the winner is, " + winner.getName()));
            return;
        }

        String from = moveMade;
        System.out.println("Please make a move: ");
        String to = sc.nextLine();

        GameContext move = new GameContext(
            players.get(currentPlayerIndex), 
            board.getCell(NotationUtils.getIndex(from)).getPiece(), 
            board.getCell(NotationUtils.getIndex(from)), 
            board.getCell(NotationUtils.getIndex(to)), 
            to,

        );

        // this.board.apply(move);

        history.add(board.cloneObject());

        
        // eventBus.publish(new MoveEvent(new Move(players.get(currentPlayerIndex), null, null, null, to)));
    }

    public void advanceTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
        Color currentColor = players.get(currentPlayerIndex).getColor();
        eventBus.publish(new GameEvent(currentColor + " TO MOVE: " + players.get(currentPlayerIndex).getName() + "'s turn") );
    }

    public GameStatus getStatus(){ return this.status; }

    public void viewReplay() {
        System.out.println("============= GAME REPLAY ============");
        for(Board board: history){
            System.out.println(board);
            sc.nextLine();
        }
    }

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
