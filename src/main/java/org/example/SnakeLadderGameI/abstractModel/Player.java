package org.example.SnakeLadderGameI.abstractModel;

import org.example.SnakeLadderGameI.model.Dice;
import org.example.SnakeLadderGameI.model.Move;
import org.example.SnakeLadderGameI.model.Symbol;
import org.example.SnakeLadderGameI.type.PlayerType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Player {
    private final String name;
    private final Symbol symbol;
    private final PlayerType type;

    public abstract Move makeMove(Dice dice);
}
