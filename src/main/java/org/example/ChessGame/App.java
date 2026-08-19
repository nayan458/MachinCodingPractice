package org.example.ChessGame;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.model.board.StandardBoard;
import org.example.ChessGame.model.events.EventBus;
import org.example.ChessGame.model.events.SimpleEventBus;
import org.example.ChessGame.model.game.Game;
import org.example.ChessGame.model.game.gameEvents.GameEvent;
import org.example.ChessGame.model.game.gameEvents.MoveEvent;
import org.example.ChessGame.model.player.Player;
import org.example.ChessGame.type.GameStatus;
import org.example.ChessGame.model.logger.Logger;

public class App {

    public static void main(String[] args) {
        Player p1 = new Player("BOB", null);
        Player p2 = new Player("Alice", null);
        Logger logger = new Logger();

        EventBus eventBus = new SimpleEventBus();

        eventBus.subscribe(GameEvent.class, p1);  // p1
        eventBus.subscribe(GameEvent.class, p2);  // p2
        eventBus.subscribe(GameEvent.class, logger);  // logger
        
        eventBus.subscribe(MoveEvent.class, p1);  // p1
        eventBus.subscribe(MoveEvent.class, p2);  // p2
        eventBus.subscribe(MoveEvent.class, logger);  // logger

        

        List<Player> players = new ArrayList<>(List.of(p1,p2));


        try {
            eventBus.publish(new GameEvent("Initializing the game..."));
            
            Game game = new Game.GameBuilder()
                                    .setBoard(new StandardBoard())
                                    .setPlayers(players)
                                    .setRuleValidator(null)
                                    .setEventBus(eventBus)
                                    .build();
            
             
            
            eventBus.publish(new GameEvent("Game is Initialized Successfully and it is ready to play."));
            eventBus.publish(new GameEvent("Current Game State: " + game.getStatus()));

            game.start();

            while(game.getStatus() != GameStatus.ENDED) {
                game.displayBoard();
                game.makeMove();
                game.displayBoard();
                if(game.getStatus() != GameStatus.ENDED)
                    game.advanceTurn();
            }

        } catch (Exception e) {
            // notifyObserver(e.getMessage());
            eventBus.publish(new GameEvent("ERROR: " + e.getMessage()));

        }
    }
}