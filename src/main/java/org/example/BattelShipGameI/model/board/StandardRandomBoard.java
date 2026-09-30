package org.example.BattelShipGameI.model.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.example.BattelShipGameI.model.Ship;
import org.example.BattelShipGameI.strategy.HozizontalPlacementStrategy;
import org.example.BattelShipGameI.strategy.IPlacementStrategy;
import org.example.BattelShipGameI.strategy.VerticalPlacementStrategy;
import org.example.BattelShipGameI.type.ShipType;
import org.example.BattelShipGameI.utils.NotationUtil;

public final class StandardRandomBoard extends Board {

    private static final int SIZE = 10;

    private static final List<Ship> SHIPS = new ArrayList<>(List.of(
        new Ship(ShipType.Aircraft_Carrier),
        new Ship(ShipType.Battleship),
        new Ship(ShipType.Submarine),
        new Ship(ShipType.Destroyer),
        new Ship(ShipType.Patrol_Boat)
    ));

    private final Random random;

    public StandardRandomBoard() throws Exception {
        super(SIZE, SHIPS);
        this.random = new Random();

        placeShips(SHIPS);
    }

    private void placeShips(List<Ship> ships) throws Exception {
        for (Ship ship : ships) {

            boolean placed = false;

            while (!placed) {
                String headCell = getRandomCell();
                IPlacementStrategy strategy = getRandomPlacementStrategy();

                try {
                    addShip(headCell, ship, strategy);
                    placed = true;
                } catch (Exception ignored) {
                    // Invalid placement.
                    // Try another random position/orientation.
                }
            }
        }
    }

    private String getRandomCell() throws Exception {
        int row = random.nextInt(SIZE);
        int col = random.nextInt(SIZE);

        return NotationUtil.getNotation(row, col);
    }

    private IPlacementStrategy getRandomPlacementStrategy() {
        if (random.nextBoolean()) {
            return new VerticalPlacementStrategy();
        }

        return new HozizontalPlacementStrategy();
    }
}