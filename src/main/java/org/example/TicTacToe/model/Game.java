package org.example.TicTacToe.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.example.TicTacToe.Strategies.BotPlayingStrategies.BotPlayingStrategyFactory;
import org.example.TicTacToe.Strategies.WinningStrategies.WinningStartegyFactory;
import org.example.TicTacToe.Strategies.WinningStrategies.WinningStrategy;
import org.example.TicTacToe.type.BotDifficultyLevel;
import org.example.TicTacToe.type.GameStatus;
import org.example.TicTacToe.type.WinningStrategyType;
import org.example.genericUtils.interfaces.Clonable;

import lombok.Getter;

@Getter
public class Game implements Clonable<Game>{

    private final Board board;
    private int nextPlayerIndex;
    private final List<Player> players;
    private final List<WinningStrategy> WinningStrategies;
    private final boolean enableBot;

    private GameStatus status;
    private Player winner;


    // Initialize Game engine
    private Game(
        Board board,
        List<Player> players,
        List<WinningStrategy> WinningStrategies,
        boolean enableBot
    ) 
    {
        this.status = GameStatus.INITIALIZING;
        System.out.println("GAME STATUS: " + this.status.toString());
        
        this.winner = null;
        this.board = board;
        this.players = players;
        this.WinningStrategies = WinningStrategies;
        this.enableBot = enableBot;

        Collections.shuffle(players);
        nextPlayerIndex = 0;

        System.out.println("==== GAME IS INITIALIZED SUCCESSFULLY ====");
        System.out.println("=== Players= ===");
        for(int i = 0; i < players.size(); i++)
            System.out.println(i + ". " + players.get(i).getName() + " (" + players.get(i).getPlayerType() + ")");

        this.status = GameStatus.READY_TO_PLAY;
        System.out.println("GAME STATUS: " + this.status.toString());
    }

    // Deep copy constructor

    private Game(Game other) 
    {
        this.board = other.board.cloneObject();
        this.nextPlayerIndex = other.nextPlayerIndex;
        this.players = new ArrayList<>(other.players);
        this.WinningStrategies = new ArrayList<>(other.WinningStrategies);
        this.enableBot = other.enableBot;
        this.status = other.status;
        this.winner = other.winner;
    }


    @Override
    public Game cloneObject() {
        return new Game(this);
    }

    public boolean getEnableBot(){ return this.enableBot; }

    public void advanceTurn(){
        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
    }

    public void endGame() { status = GameStatus.END; }
    public void setWinner(Player winner) { this.winner = winner; }

    public static class Builder {
        private static final int MAX_PLAYERS = 8;
        private final List<Player> players;
        private final List<WinningStrategy> WinningStrategies;
        private boolean ennableBot;

        private final WinningStartegyFactory winningStartegyFactory;

        public Builder() {
            this.winningStartegyFactory = new WinningStartegyFactory();
            this.WinningStrategies = new ArrayList<>();
            this.players = new ArrayList<>();
        }

        public Builder ennableBot(BotDifficultyLevel level) {
            this.ennableBot = true;
            players.add(new Bot(new BotPlayingStrategyFactory().getBot(level)));
            return this;
        }

        public Builder players(List<Player> players) {
            for(Player player: players)
                this.players.add(player);
            return this;
        }
        
        public Builder WinningStrategies(List<WinningStrategyType> WinningStrategiesTypes) throws IllegalArgumentException{
            try {
                for(WinningStrategyType type: WinningStrategiesTypes)
                    this.WinningStrategies.add(winningStartegyFactory.createWiningStrategy(type));
                return this;
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }

        public Game buildEngin()  throws Exception {
            if(players.isEmpty())
                throw new Exception("Players cannot be empty");
            if(players.size() > MAX_PLAYERS)
                throw new Exception("Not more than " + MAX_PLAYERS + " can play at a time");

            return new Game(new Board(players.size() + 1), players, WinningStrategies, ennableBot);
        }
    }

}