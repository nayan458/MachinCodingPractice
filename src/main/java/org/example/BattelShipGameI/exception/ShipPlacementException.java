package org.example.BattelShipGameI.exception;

public class ShipPlacementException extends Exception {
    public ShipPlacementException() {
        super("Ships not placeable in the provided board");
    }
}
