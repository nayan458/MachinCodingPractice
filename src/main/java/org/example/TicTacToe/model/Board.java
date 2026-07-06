package org.example.TicTacToe.model;

import java.util.ArrayList;
import java.util.List;

import org.example.TicTacToe.Exceptions.IllegalMoveException;
import org.example.TicTacToe.type.CellState;
import org.example.genericUtils.interfaces.Clonable;

import lombok.Getter;

@Getter
public class Board implements Clonable<Board> {
    private final int size;
    private final List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();
        for(int i = 0; i < this.size; i++) {
            board.add(new ArrayList<>());
            for(int j = 0; j < this.size; j++)
                board.get(i).add(new Cell(i, j, new Symbol(String.valueOf(i*size + j)), null));
        }
    }

    public Board(Board other) {
        
        this.size = other.size;
        this.board = new ArrayList<>();

        for(int i = 0; i < this.size; i++) {
            board.add(new ArrayList<>());
            for(int j = 0; j < this.size; j++)
                board.get(i).add(other.getCell(i, j).cloneObject());
        }
    }

    @Override
    public Board cloneObject() {
        return new Board(this);
    }

    public boolean isCompletelyField() {
        for(List<Cell> row: board)
            for(Cell cell: row)
                if(cell.getCellState() == CellState.EMPTY) return false;
        return true;
    }

    public void updateBoard(Cell cell, Symbol symbol, Player player) throws IllegalMoveException {
        if(cell.getCellState() == CellState.FILLED)
            throw new IllegalMoveException();
        cell.set(symbol, player);
    }

    public void displayBoard(){
        for(List<Cell> row: board) {
            for(Cell cell: row)
                System.out.print(cell);
            System.out.println();
        }
    }

    public Cell getCell(int row, int col) {
        return board.get(row).get(col);
    }

    public List<Integer> getEmptyCellId(){
        List<Integer> listOfIds = new ArrayList<>();

        for(List<Cell> row: board)
            for(Cell cell: row)
                if(cell.getCellState() == CellState.EMPTY)
                    listOfIds.add(Integer.valueOf(cell.getSymbol().toString()));
        return listOfIds;
    }
}