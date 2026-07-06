package org.example.TicTacToe.Strategies.WinningStrategies;

import java.util.List;

import org.example.TicTacToe.model.Board;
import org.example.TicTacToe.model.Cell;
import org.example.TicTacToe.model.Symbol;
import org.example.TicTacToe.type.CellState;

public class HorizentalWinningStrategy implements WinningStrategy {
    
    @Override
    public boolean checkWin(Board board) {
        List<List<Cell>> grid = board.getBoard();
        int size = board.getSize();

        for (int row = 0; row < size; row++) {

            Cell firstCell = grid.get(row).get(0);

            if (firstCell.getCellState() == CellState.EMPTY) {
                continue;
            }

            Symbol symbol = firstCell.getSymbol();
            boolean win = true;

            for (int col = 1; col < size; col++) {
                if (!grid.get(row).get(col).getSymbol().toString().equals(symbol.toString())) {
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
