package org.example.BattelShipGameI.model.board;

import org.example.BattelShipGameI.model.Ship;
import org.example.BattelShipGameI.type.CellStatus;

import lombok.Getter;

@Getter
public class Cell {
    private Ship ship;
    private CellStatus cellState;
    private final int row;
    private final int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        cellState = CellStatus.UNATTACKED;
    }

    public void setShip(Ship ship) {
        if(ship == null) return;
        this.ship = ship;
    }

    public void attack() {
        this.cellState = CellStatus.ATTACKED;
    }

    public boolean isEmpty() {
        return ship == null;
    }

    public int[] getPosition() {
        return new int[]{row, col};
    }
}
