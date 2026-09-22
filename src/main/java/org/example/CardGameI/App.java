package org.example.CardGameI;

import java.util.ArrayList;
import java.util.List;

import org.example.CardGameI.controller.GameController;
import org.example.CardGameI.model.deck.Deck;
import org.example.CardGameI.model.deck.StandardDeck;
import org.example.CardGameI.model.game.CardGame;
import org.example.CardGameI.model.game.war.WarGame;
import org.example.CardGameI.model.player.HumanPlayer;
import org.example.CardGameI.model.player.Player;
import org.example.CardGameI.service.WarGameService;
import org.example.CardGameI.type.StateType;

public class App {
    public static void main(String[] args) {

        try {

            CardGame warGame = new WarGame.WarGameBuilder()
                                .setDeck(new StandardDeck())
                                .setListOfValidStates(new ArrayList<StateType>(List.of(StateType.BATTLE, StateType.WAR)))
                                .setPlayers(new ArrayList<Player>(List.of(new HumanPlayer("Nayan", new Deck()), new HumanPlayer("Egypta", new Deck()))))
                                .setInitialState(StateType.BATTLE)
                                .build();
            
            GameController warGameController = new GameController( new WarGameService());
            warGameController.start(warGame);
            warGameController.makeMove(warGame);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
