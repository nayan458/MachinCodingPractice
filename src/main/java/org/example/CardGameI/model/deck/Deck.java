package org.example.CardGameI.model.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.example.CardGameI.model.card.Card;

import lombok.AllArgsConstructor;

 @AllArgsConstructor 
public class Deck {
    protected List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
    }

    public void suffel() {
        Collections.shuffle(cards);
    }

    public Card deal() throws Exception {
        if(cards.size() == 0)
            throw new Exception("Empty Deck");
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void addAll(Deck deck) {
        this.cards.addAll(deck.cards);
    }

    public void clear() {
        this.cards = new ArrayList<>();
    }

    public Deck deal(int numberOfCards) throws Exception {
        if(numberOfCards <= 0)
            throw new Exception("Card to be dealed should be positive");
        List<Card> temp = new ArrayList<>();
        for(int i = 0; i < numberOfCards; i++) {
            temp.add(deal());
        }
        return new Deck(temp);
    }

    public Card getLast() {
        return cards.getLast();
    }
}
