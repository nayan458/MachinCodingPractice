package org.example.CardGameI.model.player;

import org.example.CardGameI.model.deck.Deck;
import org.example.CardGameI.type.PlayerType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor 
@Getter 
public abstract class Player {
    private final String name;
    private final Deck deck;
    private final PlayerType type;

}
