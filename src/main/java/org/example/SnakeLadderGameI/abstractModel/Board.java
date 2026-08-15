package org.example.SnakeLadderGameI.abstractModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.example.SnakeLadderGameI.model.Cell;
import org.example.SnakeLadderGameI.model.Move;

public class Board {
    private final int size;
    private final Map<Integer, Cell> cells = new LinkedHashMap<>();
    private final Map<Integer, Integer> jumps = new HashMap<>();
    private final Map<Player, Cell> players = new LinkedHashMap<>();
    private boolean isGameOver = false;

    protected Board(int size, Map<Integer, Integer> jumps) {
        this.size = size;
        for (int i = 1; i <= size; i++)
            cells.put(i, new Cell(i));
        if (jumps != null)
            this.jumps.putAll(jumps);
    }

    public int getSize() { return size; }

    public boolean isGameOver() { return isGameOver; }

    public Map<Integer, Integer> getJumps() { return new HashMap<>(jumps); }

    public void initPlayers(List<Player> playersList) {
        players.clear();
        Cell start = cells.get(1);
        for (Player p : playersList)
            players.put(p, start);
    }

    public void apply(Move move) {
        Player currentPlayer = move.getPlayer();
        Cell cur = players.get(currentPlayer);
        if (cur == null)
            return;
        int currentCell = cur.getNumber();
        int nextCell = currentCell + move.getDiceValue();
        if (nextCell > size)
            return;

        if (jumps.containsKey(nextCell))
            nextCell = jumps.get(nextCell);

        players.put(currentPlayer, cells.get(nextCell));

        if(nextCell == size)
            isGameOver = true;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();

        int width = Math.min(10, size);
        List<Integer> indices = new ArrayList<>(cells.keySet());

        // Build reverse rows from top to bottom
        for (int rowStart = size; rowStart > 0; rowStart -= width) {
            int rowEnd = Math.max(1, rowStart - width + 1);
            List<Integer> row = indices.subList(rowEnd - 1, rowStart).stream()
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            // snake-like ordering: reverse every other row (so the board zig-zags)
            int rowNumber = (rowEnd - 1) / width; // zero-based
            if ((rowNumber & 1) == 0)
                java.util.Collections.reverse(row);

            for (Integer cellNum : row) {
                StringBuilder cellLabel = new StringBuilder();
                cellLabel.append(cellNum);

                if (jumps.containsKey(cellNum)) {
                    int target = jumps.get(cellNum);
                    if (target < cellNum)
                        cellLabel.append(" S->").append(target);
                    else
                        cellLabel.append(" L->").append(target);
                }

                // players on this cell
                String playersHere = players.entrySet().stream()
                        .filter(e -> Objects.equals(e.getValue().getNumber(), cellNum))
                        .map(e -> e.getKey().getSymbol().toString())
                        .collect(Collectors.joining(""));

                if (!playersHere.isEmpty())
                    cellLabel.append(" (").append(playersHere).append(")");

                // fixed width formatting
                b.append(String.format("[%-12s]", cellLabel.toString()));
            }
            b.append(System.lineSeparator());
        }

        return b.toString();
    }

}
