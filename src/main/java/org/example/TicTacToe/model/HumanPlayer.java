package org.example.TicTacToe.model;

import java.util.Scanner;

import org.example.TicTacToe.Exceptions.IllegalMoveException;
import org.example.TicTacToe.type.PlayerType;

public class HumanPlayer extends Player {

    private final static  Scanner sc = new Scanner(System.in);

    public HumanPlayer(String name, char ch) {
        super(name, PlayerType.HUMAN, new Symbol(String.valueOf(ch)));
    }
    
    

    @Override
    public Move makeMove(Board board) {
        
        while(true) {
            int cellId = sc.nextInt();
            try {
                int row = cellId/board.getSize() , col = cellId - (row * board.getSize());
                board.updateBoard(board.getCell(row, col), super.getSymbol(), this);
                return new Move(board.getCell(row, col), this);
            } catch (IllegalMoveException e) {
                System.out.println(e);
                System.out.println("Please select a valid cell");
            }
        }
    }
    
}
