package org.example.TicTacToe.Exceptions;

public class UndoEmptyListException extends Exception {
    public UndoEmptyListException(){
        super("Cannot undo on an empty List");
    }

    public UndoEmptyListException(String message) {
        super(message);
    }
}
