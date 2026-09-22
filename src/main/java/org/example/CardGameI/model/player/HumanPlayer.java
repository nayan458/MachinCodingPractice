package org.example.CardGameI.model.player;

import org.example.CardGameI.model.deck.Deck;
import org.example.CardGameI.type.PlayerType;

public class HumanPlayer extends Player {
    
    public HumanPlayer(String name, Deck deck) {
        super(name, deck, PlayerType.HUMAN);
    }
}
