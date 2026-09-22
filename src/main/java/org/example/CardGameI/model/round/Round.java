package org.example.CardGameI.model.round;

import java.util.Map;
import java.util.Set;

import org.example.CardGameI.model.deck.Deck;
import org.example.CardGameI.model.player.Player;
import org.example.CardGameI.type.GameResult;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter 
public class Round {
    private final Set<Player> participants;
    private Player roundWinner;
    private final Map<Player, Deck> cardsPlayed;
    private GameResult status;

    private Round(Builder builder) {
        this.participants = builder.participants;
        this.roundWinner = builder.roundWinner;
        this.cardsPlayed = builder.cardsPlayed;
    }

    public void transfer() {
        if(roundWinner == null) return;
        for(Deck deck: cardsPlayed.values())
            roundWinner.getDeck().addAll(deck);
    }

    public Deck getAllCardsDeck () {
        Deck allCardDeck = new Deck();
        for(Deck deck: cardsPlayed.values())
            allCardDeck.addAll(deck);
        return allCardDeck;
    } 

    public static class Builder {
        private Set<Player> participants;
        private Player roundWinner;
        private Map<Player, Deck> cardsPlayed;

        public Builder setParticipants (Set<Player> participants) {
            this.participants = participants;
            return this;
        }
        public Builder setRoundWinner (Player roundWinner) {
            this.roundWinner = roundWinner;
            return this;
        }
        public Builder setCardsPlayed (Map<Player, Deck> cardsPlayed) {
            this.cardsPlayed = cardsPlayed;
            return this;
        }

        public Round build() {
            return new Round(this);
        }
    }


}