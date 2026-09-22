package org.example.CardGameI.exception.factoryException;

public class FactoryException extends Exception {
    public FactoryException() {
        super("Factory Exception");
    }

    public FactoryException(String message) {
        super("Factory Exception: " + message);
    }

    public FactoryException(Class<?> clazz, String message) {
        super(clazz.getName() + " Exception: " + message);
    }
}
