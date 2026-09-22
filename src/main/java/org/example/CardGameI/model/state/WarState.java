package org.example.CardGameI.model.state;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.example.CardGameI.model.deck.Deck;
import org.example.CardGameI.model.player.Player;
import org.example.CardGameI.model.round.Round;
import org.example.CardGameI.strategy.evaluationStrategy.IRoundEvaluationStrategy;
import org.example.CardGameI.type.GameResult;
import org.example.CardGameI.type.StateType;

public class WarState implements IState {

    private final IRoundEvaluationStrategy evaluator;

    public WarState(List<Player> players, IRoundEvaluationStrategy evaluator){ 
        this.evaluator = evaluator;
    }

    @Override 
    public StateType getStateType() { return StateType.BATTLE; }

    @Override 
    public Round playRound(List<Player> players) throws Exception {
        
        Set<Player> participants = players.stream()
            .filter(p -> (!p.getDeck().isEmpty() && p.getDeck().size() >= 4))
            .collect(Collectors.toSet());
        
        Map<Player, Deck> cardsPlayed = participants.stream()
                                            .collect(
                                                Collectors.toMap(
                                                    player -> player, 
                                                    player -> {
                                                        Deck deck = new Deck();
                                                        try {
                                                            if(player.getDeck().size() >= 4)
                                                                deck.addAll(player.getDeck().deal(4));
                                                        } catch (Exception e) {
                                                            deck.addAll(player.getDeck());
                                                            player.getDeck().clear();
                                                            return deck;
                                                        }
                                                        return deck;
                                                    }
                                                )
                                            );

        return new Round.Builder().setParticipants(participants).setCardsPlayed(cardsPlayed).build();
    }

    @Override 
    public GameResult evaluate(Round round) {
        return evaluator.evaluate(round);
    }

    @Override
    public List<Player> getQualifiedPlayers(List<Player> players) {
        return players.stream()
                .filter(p -> p.getDeck().size() >= 1)
                .collect(Collectors.toList());
    }
}
