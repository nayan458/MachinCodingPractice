package org.example.ChessGame.exception.pieceCreationException;

public class IllegalPieceCreationException extends Exception {
    public IllegalPieceCreationException(){
        super("Illeagal Piece Creation: " + "No such piece exist in our system");
    }

    public IllegalPieceCreationException(String message){
        super("Illeagal Piece Creation: " + message);
    }
}
