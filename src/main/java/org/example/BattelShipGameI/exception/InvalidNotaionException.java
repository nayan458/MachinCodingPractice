package org.example.BattelShipGameI.exception;

public class InvalidNotaionException extends Exception {
    public InvalidNotaionException() {
        super("INVALID NOTATION");
    }

    public InvalidNotaionException(String message) {
        super("INVALID NOTATION: " + message);
    }
}
