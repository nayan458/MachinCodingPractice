package org.example.ChessGame.strategy.movementStrategy;

import java.util.List;

import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.board.Cell;
import org.example.ChessGame.type.Color;

public interface IMovementStrategy {
    List<Cell> getListOfMoves(Cell from, Board board);
    boolean isValid(Cell cell, Color color);
}
