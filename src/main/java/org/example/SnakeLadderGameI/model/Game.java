package org.example.SnakeLadderGameI.model;

import java.util.Collections;
import java.util.List;

import org.example.SnakeLadderGameI.abstractModel.Board;
import org.example.SnakeLadderGameI.abstractModel.Player;
import org.example.SnakeLadderGameI.exception.GameNotEndedException;
import org.example.SnakeLadderGameI.registery.BoardRegistery.BoardRegistry;
import org.example.SnakeLadderGameI.type.BoardType;
import org.example.SnakeLadderGameI.type.GameStatus;

public class Game {
    private final Board board;
    private final List<Player> players;
    private final Dice dice;
    private Integer currentPlayerIndex;
    
    private GameStatus status;
    private Player winner;

    private Game(Board board, List<Player> players, Dice dice){
        this.status = GameStatus.INITIALIZING;
        this.board = board;
        this.players = players;
        this.dice = dice;
        this.currentPlayerIndex = 0;
        // initialize players on board
        this.board.initPlayers(players);
        this.status = GameStatus.ON_PROGRESS;
    }

    public void makeMove(Move move) {
        board.apply(move);
        if(board.isGameOver()){
            this.status = GameStatus.ENDED;
            this.winner = move.getPlayer();
        }
    }

    public void advanceTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public Dice getDice() {
        return this.dice;
    }

    public Player getNextPlayer() {
        return players.get(currentPlayerIndex);
    }

    public Player getWinner() throws GameNotEndedException {
        if(status != GameStatus.ENDED)
            throw new GameNotEndedException();
        return winner;
    }

    public GameStatus getGameStatus() { return this.status; }

    public void displayBoard() { System.out.println(board); }

    public static class GameBuilder {
        private List<Player> players;
        private BoardType type;
        private Dice dice;

        public GameBuilder setPlayers(List<Player> players) { this.players = players; return this; }

        public GameBuilder standard(){ this.type = BoardType.STANDARD; return this; }
        public GameBuilder easy(){ this.type = BoardType.EASY; return this; }
        public GameBuilder hard(){ this.type = BoardType.HARD; return this; }

        public GameBuilder setDice(Dice dice) { this.dice = dice; return this; }

        public Game build() {
            Collections.shuffle(players);
            return new Game(BoardRegistry.getInstance().getItem(type) , players, dice);
        }

    }
}
