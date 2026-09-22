package org.example.CardGameI.model.deck;

import java.util.ArrayList;

import org.example.CardGameI.model.card.Card;
import org.example.CardGameI.type.Rank;
import org.example.CardGameI.type.Suit;

// deck with standard 52 cards.

public class StandardDeck extends Deck {
    private static final Suit[] VALID_SUITS = {
        Suit.HEARTS, Suit.DIAMONDS, Suit.CLUBS, Suit.SPADES
    };
    
    private static final Rank[] VALID_RANKS = {
        Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE,
        Rank.SIX, Rank.SEVEN, Rank.EIGHT, Rank.NINE,
        Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE
    };
    
    public StandardDeck() {
        super(new ArrayList<>());
        for(Suit suit : VALID_SUITS) {
            for(Rank rank : VALID_RANKS) {
                cards.add(new Card(suit, rank));
            }
        }
    }
}
