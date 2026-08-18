package org.example.ChessGame.model.piece;

import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.strategy.movementStrategy.IMovementStrategy;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.PieceType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Piece {
    private final PieceType type;
    private final Color color;
    private final List<IMovementStrategy> movementStrategies;

    public abstract List<Cell> getValidPositions(Cell from, Board board);
    public abstract String display();
}
