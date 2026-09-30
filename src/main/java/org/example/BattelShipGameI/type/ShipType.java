package org.example.BattelShipGameI.type;

public enum ShipType {

    Aircraft_Carrier(new int[][] {{0,0},{1,0},{1,-1},{1,1},{2,0},{3,0},}),
    Battleship(new int[][] {{0,0},{1,0},{2,0},{3,0},}),
    Submarine(new int[][] {{0,0},{1,0},{2,0}}), 
    Destroyer(new int[][] {{0,0},{1,0}}), 
    Patrol_Boat(new int[][] {{0,0}});

    private int[][] offset;

    private ShipType(int[][] offset) {
        this.offset = offset;
    }

    public int[][] getOffset() {
        return offset;
    }
}
