package org.example.CardGameI.model.card;

import org.example.CardGameI.type.Rank;
import org.example.CardGameI.type.Suit;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor 
@Getter 
public class Card implements Comparable<Card> {
    private final Suit suit;
    private final Rank rank;

    public int getValue() { return rank.getValue(); }

    @Override 
    public int compareTo(Card other) {
        return this.rank.getValue() - other.rank.getValue();
    }
}