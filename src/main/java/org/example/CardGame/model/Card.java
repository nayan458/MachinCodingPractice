package org.example.CardGame.model;

import org.example.CardGame.type.RankType;
import org.example.CardGame.type.SuitType;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Card {
    private final SuitType suit;
    private final RankType rank;
}
