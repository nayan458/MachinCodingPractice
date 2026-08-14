package org.example.SnakeLadderGameI.abstractModel;

import java.util.Map;

import org.example.SnakeLadderGameI.model.Cell;
import org.example.SnakeLadderGameI.model.Move;

public class Board {
    private static int size;
    private Map<Integer, Cell> cell;
    private Map<Integer, Integer> jumps;
    private Map<Player, Cell> players;

    // toString
    @Override
    public String toString() {
        return "";
    }

    public void apply(Move move) {
        Player currentPlayer = move.getPlayer();
        int currentCell = players.get(currentPlayer).getNumber();
        int nextCell = currentCell + move.getDiceValue();
        if(nextCell > size) return;

        if(jumps.containsKey(nextCell))
            nextCell = jumps.get(nextCell);

        players.put(currentPlayer, cell.get(nextCell));
    }

}
