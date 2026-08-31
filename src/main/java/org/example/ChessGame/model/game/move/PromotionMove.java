package org.example.ChessGame.model.game.move;

import java.util.Scanner;

import org.example.ChessGame.exception.pieceCreationException.IllegalPieceCreationException;
import org.example.ChessGame.factory.PieceFactory;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.game.GameContext;
import org.example.ChessGame.model.piece.Piece;
import org.example.ChessGame.type.PieceType;

import lombok.Getter;

@Getter
public class PromotionMove extends Move {
    private final Piece promotedTo;
    
    public PromotionMove (GameContext ctx) throws IllegalPieceCreationException {
        super(ctx);
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the Piece You want it to convert to: ");
            System.out.println("Select piece by entering the value within the bracket: \nPawn(P) \nKnight(N) \nBishop(B) \nRook(R) \nQueen(Q)");
            String pieceType = sc.nextLine();
            this.promotedTo = PieceFactory.create(
                PieceFactory.pieceTypeResolver(pieceType), 
                ctx.getPiece().getColor()
            );
        }
    }

    @Override
    public boolean isPatterLegal(Board board) {
        if(promotedTo.getType() == PieceType.KING)
            return false;
        return true;
    }

    @Override
    public void apply(Board board) {
        from.clear();
        to.setPiece(promotedTo);    
    }

}
