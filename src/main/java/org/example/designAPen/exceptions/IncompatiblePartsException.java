package org.example.designAPen.exceptions;

public class IncompatiblePartsException extends Exception {
    public IncompatiblePartsException() {
        super("The parts of the pen are not fit to create a complete pen.");
    }
    
    public IncompatiblePartsException(String text) {
        super(text);
    }
}
