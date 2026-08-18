package org.example.ChessGame.strategy.movementStrategy;

import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;

public interface IMovementStrategy {
    List<Cell> getListOfMoves(Cell from, Board board);
}
