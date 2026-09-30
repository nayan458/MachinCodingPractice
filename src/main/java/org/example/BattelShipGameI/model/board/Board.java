package org.example.BattelShipGameI.model.board;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.example.BattelShipGameI.exception.IndexOutOfBoundsException;
import org.example.BattelShipGameI.model.Move;
import org.example.BattelShipGameI.model.Ship;
import org.example.BattelShipGameI.strategy.IPlacementStrategy;
import org.example.BattelShipGameI.type.CellStatus;
import org.example.BattelShipGameI.utils.NotationUtil;

public class Board {
    private final int size;       // for this lld design we consider it to be a n * n square board 
    private final List<List<Cell>> board;
    private Set<String> emptyCell;
    private int remainingShip;

    public Board(int size, List<Ship> ships) {
        this.size = size;
        this.board = new ArrayList<>();
        this.emptyCell = new HashSet<>();
        this.remainingShip = 0;

        for(int i = 0; i < size; i++) {
            board.add(new ArrayList<>());
            for(int j = 0; j < size; j++) {
                board.get(i).add(new Cell(i,j));
                try {
                    emptyCell.add(NotationUtil.getNotation(i, j));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }

    public int getRemainingShip() {
        return remainingShip;
    }

    public int getSize(){ return this.size; }

    public void addShip(String headCell, Ship ship, IPlacementStrategy placemtStrategy) throws Exception {
        List<int[]> offset = placemtStrategy.getOffSet(ship.getShipType().getOffset());
        List<Cell> validCells = getValidCells(NotationUtil.resolveCellIndex(headCell), offset);

        for(Cell cell: validCells) {
            cell.setShip(ship);
            int[] cellIndices = cell.getPosition(); // returns int[]{row, col}
            emptyCell.remove(NotationUtil.getNotation(cellIndices[0], cellIndices[1]));
        }

        remainingShip++;
    }

    public Set<String> getEmptyCells() {
        return emptyCell;
    }

    public Cell getCell(String cellIndex) throws Exception {
        int indices[] = NotationUtil.resolveCellIndex(cellIndex);
        int row = indices[0];
        int col = indices[1];
        return board.get(row).get(col);
    }

    private List<Cell> getValidCells(int[] head, List<int[]> offseList) throws Exception {
        List<Cell> validCells = new ArrayList<>();

        for(int[] offset : offseList) {
            int row = head[0] + offset[0];
            int col = head[1] + offset[1];

            if(row < 0 || row >= size || col < 0 || col >= size)
                throw new IndexOutOfBoundsException();

            validCells.add(board.get(row).get(col));
        }
        // check cell not out of index
        // 
        throw new Exception();
    }

    public void applyMove(Move move) throws Exception {
        Cell targetCell = getCell(move.getMove());

        if(targetCell.getCellState() == CellStatus.ATTACKED)
            throw new Exception("Cell is already attacked");
        
        targetCell.attack();
        
        if(!targetCell.isEmpty()) {
            Ship ship = targetCell.getShip();
            if(ship.isSink()) 
                remainingShip--;
            System.out.println("HIT");
        } else {
            System.out.println("MISS");
        }
    }
}
