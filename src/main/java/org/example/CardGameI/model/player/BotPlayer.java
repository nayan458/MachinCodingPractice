package org.example.CardGameI.model.player;

import org.example.CardGameI.model.deck.Deck;
import org.example.CardGameI.type.PlayerType;

public class BotPlayer extends Player {
    public BotPlayer(String name, Deck deck) {
        super(name, deck, PlayerType.BOT);
    }
}
