package org.example.BattelShipGameI.model;

import java.util.List;

import org.example.BattelShipGameI.type.ShipType;

public class Ship {
    public ShipType type;
    public List<int[]> offset;
    public int hitCount;

    public Ship(ShipType type) {
        this.type = type;
        this.hitCount = 0;
    }

    public ShipType getShipType() {
        return this.type;
    }

    public void setOffSet(List<int[]> offset) {
        this.offset = offset;
    }

    public void hit() {
        hitCount++;
    }

    public boolean isSink() {
        return hitCount == offset.size();
    }
}
