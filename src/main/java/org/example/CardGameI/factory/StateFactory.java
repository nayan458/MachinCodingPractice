package org.example.CardGameI.factory;

import java.util.List;

import org.example.CardGameI.exception.factoryException.FactoryException;
import org.example.CardGameI.model.player.Player;
import org.example.CardGameI.model.state.BattleState;
import org.example.CardGameI.model.state.IState;
import org.example.CardGameI.model.state.WarState;
import org.example.CardGameI.strategy.evaluationStrategy.LastCardWinStrategy;
import org.example.CardGameI.type.StateType;

public final class StateFactory {
    public static IState getStateInstance(StateType state, List<Player> players) throws FactoryException {
        return switch (state) {
            case BATTLE -> new BattleState(players, new LastCardWinStrategy());
            case WAR -> new WarState(players, new LastCardWinStrategy());
            default -> throw new FactoryException(StateFactory.class, "State not found");
        };
    }
}
