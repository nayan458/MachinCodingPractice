package org.example.SnakeLadderGameI;

import java.util.Arrays;
import java.util.List;

import org.example.SnakeLadderGameI.abstractModel.Player;
import org.example.SnakeLadderGameI.controller.GameController;
import org.example.SnakeLadderGameI.model.Bot;
import org.example.SnakeLadderGameI.model.Dice;
import org.example.SnakeLadderGameI.model.Game;
import org.example.SnakeLadderGameI.model.Human;
import org.example.SnakeLadderGameI.model.Symbol;
import org.example.SnakeLadderGameI.service.GameService;
import org.example.SnakeLadderGameI.type.PlayerType;

public class App {
    public static void main(String[] args) {
        Dice dice = new Dice(6);

        Human h = new Human.HumanBuilder()
                .setname("Alice")
                .settype(PlayerType.HUMAN)
                .setsymbol(new Symbol("A"))
                .build();

        Bot b = new Bot.BotBuilder()
                .setName("Bot")
                .setType(PlayerType.BOT)
                .setSymbol(new Symbol("B"))
                .build();

        List<Player> players = Arrays.asList(h, b);

        Game game = new Game.GameBuilder()
                .setPlayers(players)
                .standard()
                .setDice(dice)
                .build();

        GameService service = new GameService();
        GameController controller = new GameController(service);

        // Run a small number of moves to demonstrate play
        for (int i = 0; i < 20; i++) {
            controller.makeMove(game);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}