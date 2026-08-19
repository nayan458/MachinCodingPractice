package org.example.ChessGame.model.piece;

import java.util.List;

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
    private final List<IMovementStrategy> movementStrategies;

    public Piece(Piece other) {
        this.type = other.type;
        this.color = other.color;
        this.movementStrategies = other.movementStrategies;
    }

    public abstract List<Cell> getValidPositions(Cell from, Board board);
    public abstract String display();
}
