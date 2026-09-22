package org.example.CardGameI.controller;

import java.util.Scanner;

import org.example.CardGameI.model.game.CardGame;
import org.example.CardGameI.service.GameService;

public class GameController {
    private final GameService gameService;
    private final Scanner scanner;

    public GameController(GameService gameService) {
        this.gameService = gameService;
        this.scanner = new Scanner(System.in);
    }

    public boolean isEnded(CardGame game) { return gameService.isEnded(game); }

    public void start(CardGame game) {
        try {
            gameService.start(game);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void makeMove(CardGame game) {
        try {
            while(!gameService.isEnded(game)) {
                gameService.playGame(game);
    
                promptForNextRound();
            }

            gameService.displayResult(game);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void promptForNextRound() {
        System.out.println("\nPress enter for next round");
        scanner.nextLine();
    }

    public void displayResult(CardGame game) {}
}
