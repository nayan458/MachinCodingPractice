package org.example.TicTacToe.Strategies.WinningStrategies;

import java.util.List;

import org.example.TicTacToe.model.Board;
import org.example.TicTacToe.model.Cell;
import org.example.TicTacToe.model.Symbol;
import org.example.TicTacToe.type.CellState;

public class DiagonalWinningStrategy implements WinningStrategy{

    @Override
    public boolean checkWin(Board board) {

        List<List<Cell>> grid = board.getBoard();
        int size = board.getSize();

        // Main diagonal
        Cell first = grid.get(0).get(0);

        if (first.getCellState() != CellState.EMPTY) {

            Symbol symbol = first.getSymbol();
            boolean win = true;

            for (int i = 1; i < size; i++) {
                if (!grid.get(i).get(i).getSymbol().toString().equals(symbol.toString())) {
                    win = false;
                    break;
                }
            }

            if (win) {
                return true;
            }
        }

        // Secondary diagonal
        first = grid.get(0).get(size - 1);

        if (first.getCellState() != CellState.EMPTY) {

            Symbol symbol = first.getSymbol();
            boolean win = true;

            for (int i = 1; i < size; i++) {
                if (!grid.get(i).get(size - 1 - i).getSymbol().toString().equals(symbol.toString())) {
                    win = false;
                    break;
                }
            }

            if (win) {
                return true;
            }
        }

        return false;
    }    
}
