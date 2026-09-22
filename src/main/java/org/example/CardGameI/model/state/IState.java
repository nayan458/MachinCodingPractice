package org.example.CardGameI.model.state;

import java.util.List;

import org.example.CardGameI.model.player.Player;
import org.example.CardGameI.model.round.Round;
import org.example.CardGameI.type.GameResult;
import org.example.CardGameI.type.StateType;

public interface IState {
    public Round playRound(List<Player> players) throws Exception;
    public GameResult evaluate(Round round);
    public List<Player> getQualifiedPlayers(List<Player> players);
    public StateType getStateType();
}
