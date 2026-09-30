package org.example.BattelShipGameI.exception;

public class IndexOutOfBoundsException extends Exception {
    public IndexOutOfBoundsException() {
        super("INDEX OUT OF BOUND");
    }

    public IndexOutOfBoundsException(String message) {
        super("INDEX OUT OF BOUND: " + message);
    }
    
}
