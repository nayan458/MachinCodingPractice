package org.example.CardGameI.model.game.war;

import java.util.ArrayList;
import java.util.List;

import org.example.CardGameI.model.deck.Deck;
import org.example.CardGameI.model.game.CardGame;
import org.example.CardGameI.model.player.Player;
import org.example.CardGameI.model.round.Round;
import org.example.CardGameI.type.GameResult;
import org.example.CardGameI.type.GameStatus;
import org.example.CardGameI.type.StateType;

public class WarGame extends CardGame {

    private static int MAX_SIZE = 4;
    private Round round;
    private List<Round> history;
    private List<Player> qualifiedPlayer;
    private Deck pot;

    private WarGame(WarGameBuilder builder) throws Exception {
        super(builder);
        this.pot = new Deck();
        this.history = new ArrayList<>();
    }

    @Override
    public void start() throws Exception {
        deck.suffel();
        dealCard();
        status = GameStatus.IN_PROGRESS;
    }
    
    @Override 
    public void makeMove() throws Exception {
        this.round = state.playRound(players);
    }

    @Override 
    public GameResult evaluate() {
        return state.evaluate(round);
    }

    @Override 
    public void evaluateGameState() {
        this.qualifiedPlayer = state.getQualifiedPlayers(this.players); 
        if(qualifiedPlayer.size() == 1) {
            this.status = GameStatus.COMPLETED;
            this.winner = state.getQualifiedPlayers(this.players).getFirst();
        }
    }

    @Override 
    public void gameStateTransition() throws Exception {
        switch (round.getStatus()) {
            case TIE:
                addToPot();
                setState(StateType.WAR);
                break;
            case WIN:
                addWinnerToPot();
                clearPot();
                setState(StateType.BATTLE);
            default:
                break;
        }
    }

    public void clearPot() {
        pot.clear();
    }

    public void addWinnerToPot() {
        round.getRoundWinner().getDeck().addAll(round.getAllCardsDeck());
    }

    public void addToPot () {
        pot.addAll(round.getAllCardsDeck());
    }

    @Override 
    public void nextRound() {
        this.history.add(round);
        this.round = null;
    }

    public int getPotSize() { return pot.size(); }

    public static class WarGameBuilder extends CardGame.Builder<WarGame> {

        @Override
        public WarGame build() throws Exception {
            if(players.size() > MAX_SIZE || players.size() < 2) 
                throw new IllegalArgumentException("There should be atleast 2 players and there can be at most" + MAX_SIZE + "plaers");
            if(deck.size() % players.size() != 0)
                throw new IllegalArgumentException("cards shuould be equally distrubutable");
            return new WarGame(this);
        }
    }

    private void dealCard() throws Exception{
        while(!deck.isEmpty()) {
            for(Player player: players) {
                player.getDeck().add(deck.deal());
            }
        }
    }

}
