package org.example.ChessGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.example.ChessGame.exception.gameRulesException.IllegalMoveException;
import org.example.ChessGame.exception.gameRulesException.RuleViolationException;
import org.example.ChessGame.model.board.StandardBoard;
import org.example.ChessGame.model.events.EventBus;
import org.example.ChessGame.model.events.SimpleEventBus;
import org.example.ChessGame.model.game.Game;
import org.example.ChessGame.model.game.gameEvents.GameEvent;
import org.example.ChessGame.model.game.gameEvents.MoveEvent;
import org.example.ChessGame.model.game.rule.PatternLeagalityRule;
import org.example.ChessGame.model.game.rule.PieceExistanceRule;
import org.example.ChessGame.model.game.rule.Rule;
import org.example.ChessGame.model.game.rule.RuleValidator;
import org.example.ChessGame.model.game.rule.SelfCheckRule;
import org.example.ChessGame.model.game.rule.TurnCheckRule;
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

        Rule pieceExistanceRule = new PieceExistanceRule();
        Rule checkTurn = new TurnCheckRule();
        Rule patternLegalityRule = new PatternLeagalityRule();
        Rule selfCheckRule = new SelfCheckRule();

        pieceExistanceRule.setNext(checkTurn);
        checkTurn.setNext(patternLegalityRule);
        patternLegalityRule.setNext(selfCheckRule);



        try {
            eventBus.publish(new GameEvent("Initializing the game..."));
            
            Game game = new Game.GameBuilder()
                                    .setBoard(new StandardBoard())
                                    .setPlayers(players)
                                    .setRuleValidator(new RuleValidator(pieceExistanceRule))
                                    .setEventBus(eventBus)
                                    .build();
            
             
            
            eventBus.publish(new GameEvent("Game is Initialized Successfully and it is ready to play."));
            eventBus.publish(new GameEvent("Current Game State: " + game.getStatus()));

            game.start();
            game.displayBoard();

            while(game.getStatus() == GameStatus.ON_PROGRESS) {

                try {
                    game.makeMove();
                    game.displayBoard();
                    game.evaluateBoardStatus();

                    if(game.getStatus() == GameStatus.ON_PROGRESS)
                        game.advanceTurn();
                } catch (IllegalMoveException e) {
                   System.out.println(e.getMessage());
                } catch (RuleViolationException e) {
                    System.out.println(e.getMessage());
                }
            }

            game.displayStatus();

            System.out.println("Do you want to view replay? type (Y) for yes.");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if(input.equals("Y"))
                game.viewReplay();
            sc.close();
            
            System.out.println("\n\n=========== GAME LOGS =============");
            logger.displayLogs();

        } catch (Exception e) {
            // notifyObserver(e.getMessage());
            eventBus.publish(new GameEvent("ERROR: " + e.getMessage()));
        }

    }
}