package org.example.SnakeLadderGameI.controller;

import org.example.SnakeLadderGameI.abstractModel.Player;
import org.example.SnakeLadderGameI.model.Game;
import org.example.SnakeLadderGameI.model.Move;
import org.example.SnakeLadderGameI.service.GameService;
import org.example.SnakeLadderGameI.type.GameStatus;
import org.example.SnakeLadderGameI.type.PlayerType;

public class GameController {
    private GameService gameService;
    private static final java.util.Scanner INPUT = new java.util.Scanner(System.in);

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public boolean isGameOver(Game game) {
        return gameService.getGameStatus(game) == GameStatus.ENDED;
    }

    public void makeMove(Game game) {
        Player next = gameService.getNextPlayer(game);

        if (next.getType() == PlayerType.HUMAN) {
            System.out.println("It's " + next.getName() + "'s turn. Please hit ENTER to roll the dice.");
            try {
                INPUT.nextLine();
            } catch (Exception e) {
                // ignore input issues and continue
            }
        }

        try {
            Move move = next.makeMove(game.getDice());
            game.makeMove(move);
            game.advanceTurn();
        } catch (Exception e) {
            System.out.println("Error making move: " + e.getMessage());
        }

        gameService.displayBoard(game);
        if(gameService.getGameStatus(game) == GameStatus.ENDED) {
            try {
                System.out.println("The winner is " + gameService.getWinner(game).getName());
            } catch (Exception e) {
                System.out.print(e);
            }
        }
    }

}
