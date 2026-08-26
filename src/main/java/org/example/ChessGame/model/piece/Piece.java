package org.example.ChessGame.model.piece;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.strategy.movementStrategy.IMovementStrategy;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.PieceType;
import org.example.genericUtils.interfaces.Clonable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Piece implements Clonable<Piece> {
    private final PieceType type;
    private final Color color;
    protected final List<IMovementStrategy> movementStrategies;

    public Piece(Piece other) {
        this.type = other.type;
        this.color = other.color;
        this.movementStrategies = other.movementStrategies;
    }

    public Set<Cell> getValidPositions(Cell from, Board board) {
        Set<Cell> validPositions = new HashSet<>();
        for(IMovementStrategy movementStrategie: movementStrategies)
            validPositions.addAll(movementStrategie.getListOfMoves(from, board));
        return validPositions;
    }
    public abstract String display();
}
