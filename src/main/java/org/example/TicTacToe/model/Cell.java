package org.example.TicTacToe.model;

import org.example.TicTacToe.type.CellState;
import org.example.genericUtils.interfaces.Clonable;

import lombok.Getter;

@Getter
public class Cell implements Clonable<Cell> {
    private final int row;
    private final int col;
    private Symbol symbol;
    private Player player;
    private CellState cellState;

    public Cell(int row, int col, Symbol symbol, Player player) {
        this.row = row;
        this.col = col;
        this.symbol = symbol;
        this.player = player;
        this.cellState = CellState.EMPTY;
    }

    public Cell(Cell other) {
        this.row = other.row;
        this.col = other.col;
        this.symbol = other.symbol;
        this.player = other.player;
        this.cellState = other.cellState;
    }

    @Override
    public Cell cloneObject() {
        return new Cell(this);
    }

    public void set(Symbol symbol, Player player) {
        this.symbol = symbol;
        this.player = player;
        this.cellState = CellState.FILLED;
    }

    @Override
    public String toString() {
    return String.format("| %-3s |", symbol);
    }
}