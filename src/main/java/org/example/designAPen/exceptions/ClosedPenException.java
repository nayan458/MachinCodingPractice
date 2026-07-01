package org.example.designAPen.exceptions;

public class ClosedPenException extends Exception {
    public ClosedPenException(){
        super("Please open the pen before you start writing");
    }

    public ClosedPenException(String message) {
        super(message);
    }
}
