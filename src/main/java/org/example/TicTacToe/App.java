package org.example.TicTacToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.example.TicTacToe.controller.Gamecontroller;
import org.example.TicTacToe.model.Game;
import org.example.TicTacToe.model.HumanPlayer;
import org.example.TicTacToe.model.Player;
import org.example.TicTacToe.service.GameService;
import org.example.TicTacToe.type.BotDifficultyLevel;
import org.example.TicTacToe.type.GameStatus;
import org.example.TicTacToe.type.WinningStrategyType;

public class App {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        List<Player> players = new ArrayList<>();

        players.add(new HumanPlayer("Barun", 'X'));
        players.add(new HumanPlayer("Nayan", 'O'));
        players.add(new HumanPlayer("Egypta", 'Y'));

        try {

            Game game = new Game.Builder()
                    .players(players)
                    .ennableBot(BotDifficultyLevel.EASY)
                    .WinningStrategies(
                            List.of(
                                    WinningStrategyType.HORIZENTAL,
                                    WinningStrategyType.VERTICAL,
                                    WinningStrategyType.DIAGONAL))
                    .buildEngin();

            Gamecontroller controller =
                    new Gamecontroller(new GameService(game));

            System.out.println("\n========== TIC TAC TOE ==========\n");

            while (controller.getStatus(game) != GameStatus.END) {

                controller.displayBoard(game);

                Player currentPlayer = controller.getNextPlayer(game);

                System.out.println();
                System.out.println("--------------------------------");
                System.out.println("Current Player : " + currentPlayer.getName());
                System.out.println("Symbol         : " + currentPlayer.getSymbol());
                System.out.println("--------------------------------");

                System.out.println("Choose an option: \n1 -> Make Move\n2 -> Undo\n3 -> Exit");

                int option = sc.nextInt();

                switch (option) {
                    case 1: controller.makeMove(game);
                        break;
                    case 2: {
                        game = controller.undo();
                        System.out.println("\nLast move undone.\n");
                        break;
                    }
                    case 3: {
                        System.out.println("Game terminated.");
                        return;
                    }
                    default: System.out.println("Invalid option.");
                }

                System.out.println();
            }

            System.out.println("\n========== FINAL BOARD ==========\n");
            controller.displayBoard(game);

            Player winner = controller.getWinner(game);

            if (winner == null) {
                System.out.println("\nGame Drawn!");
            } else {
                System.out.println("\nWinner : " + winner.getName());
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}