package org.example.ChessGame;

import java.util.ArrayList;
import java.util.List;

import org.example.ChessGame.model.board.StandardBoard;
import org.example.ChessGame.model.game.Game;
import org.example.ChessGame.model.player.Player;

public class App {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player());
        players.add(new Player());
        try {
            Game game = new Game.GameBuilder()
                            .setBoard(new StandardBoard())
                            .setPlayers(players)
                            .setRuleValidator(null)
                            .build();
                            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}