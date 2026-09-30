package org.example.BattelShipGameI;

import java.util.Scanner;

import org.example.BattelShipGameI.model.Game;
import org.example.BattelShipGameI.model.Player;
import org.example.BattelShipGameI.model.board.StandardRandomBoard;
import org.example.BattelShipGameI.type.GameStatus;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Player p1 = new Player("Player1", sc);
    Player p2 = new Player("Player2", sc);

    try {
      Game battelShipGame = new Game.Builder()
                                .setPlayer(p1, new StandardRandomBoard())
                                .setPlayer(p2, new StandardRandomBoard())
                                .build();

      battelShipGame.start();

      while(battelShipGame.getGameStatus() == GameStatus.ON_PROGRESS) {
        try {
          battelShipGame.makeMove();
          battelShipGame.advanceTurn();
        } catch (Exception e) {
          System.out.print(e.getMessage());
        }
      }

      if(battelShipGame.getGameStatus() == GameStatus.ENDED)
          System.out.println("The Winner is: " + battelShipGame.getWinner());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
