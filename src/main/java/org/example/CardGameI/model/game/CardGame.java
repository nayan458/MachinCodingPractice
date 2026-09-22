package org.example.CardGameI.model.game;

import java.util.List;

import org.example.CardGameI.factory.StateFactory;
import org.example.CardGameI.model.deck.Deck;
import org.example.CardGameI.model.player.Player;
import org.example.CardGameI.model.state.IState;
import org.example.CardGameI.type.GameResult;
import org.example.CardGameI.type.GameStatus;
import org.example.CardGameI.type.StateType;

public abstract class CardGame {
    protected final List<Player> players;
    protected final List<StateType> validStates;
    protected final Deck deck;
    protected IState state;
    protected GameStatus status;
    protected Player winner;

    protected CardGame (Builder<?> builder) throws Exception {
        this.players = builder.players;
        this.validStates = builder.validStates;
        this.deck = builder.deck;
        this.status = GameStatus.NOT_STARTED;
        this.winner = null;
        
        if(players == null || builder.initialState == null || validStates == null || deck == null) 
            throw new IllegalArgumentException("Please check that you have correctly set all the fields: players, state, listOfValidStates, deck and non of them is null");
        if(!validStates.contains(builder.initialState)) 
            throw new IllegalArgumentException("Not a valid state");

        this.state = StateFactory.getStateInstance(builder.initialState, players);
    }

    public Player getWinner() { return winner; }

    public GameStatus getStatus() { return this.status;}
    public List<Player> getPlayers() { return this.players; }

    public abstract void start() throws Exception;
    public abstract void makeMove() throws Exception;
    public abstract GameResult evaluate();
    public abstract void evaluateGameState();
    public abstract void gameStateTransition() throws Exception;
    public abstract void nextRound();

    public void setState(StateType type) throws Exception {
        this.state = StateFactory.getStateInstance(type, players);
    }

    public IState getState() { return state; }

    public static abstract class Builder<T extends  CardGame> {
        protected List<Player> players;
        protected StateType initialState;
        protected List<StateType> validStates;
        protected Deck deck;

        public Builder<T> setPlayers(List<Player> players) { this.players = players; return this; }
        public Builder<T> setInitialState(StateType initialState) { this.initialState = initialState; return this; }
        public Builder<T> setListOfValidStates(List<StateType> validStates) { this.validStates = validStates; return this; }
        public Builder<T> setDeck(Deck deck) { this.deck = deck; return this; }

        public abstract T build() throws Exception;
    }
    
}
