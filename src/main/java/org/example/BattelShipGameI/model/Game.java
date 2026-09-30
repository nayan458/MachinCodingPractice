package org.example.BattelShipGameI.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.example.BattelShipGameI.model.board.Board;
import org.example.BattelShipGameI.model.board.Cell;
import org.example.BattelShipGameI.type.CellStatus;
import org.example.BattelShipGameI.type.GameStatus;

public class Game {
    private final List<Player> players;
    private final Map<Player, Board> map;
    private int currAttackerIndex;
    private int currDefenderIndex;
    private GameStatus status;
    private Player winner;

    private Game (Builder builder) {
        this.status = GameStatus.INITIALIZING;
        this.players = builder.players;
        this.map = builder.map;
        Collections.shuffle(players);
        this.currAttackerIndex = 0;
        this.currDefenderIndex = (currAttackerIndex + 1) % players.size();
    }

    public void start() {
        this.status = GameStatus.ON_PROGRESS;
    }

    public GameStatus getGameStatus() { 
        return this.status; 
    }

    public void advanceTurn() {
        currAttackerIndex = (currAttackerIndex + 1) % players.size();
        currDefenderIndex = (currAttackerIndex + 1) % players.size();
    }

    public void makeMove() throws Exception {
        if(this.status != GameStatus.ON_PROGRESS)
            switch (this.status) {
                case INITIALIZING -> throw new Exception("Please start the game to make a move.");
                case ENDED -> throw new Exception("Game ended.");
                case ON_PROGRESS -> { }
            }
        Player attacker = players.get(currAttackerIndex);
        Board board = map.get(players.get(currDefenderIndex));

        System.out.println(attacker + " to make a move: ");

        String notation = attacker.makeMove();

        Move move = new Move(attacker, board, notation);
        validateMove(move);

        board.applyMove(move);

        evaluateGameStatus(board);
    }

    public Player getWinner() throws Exception { 
        if(this.status == GameStatus.ENDED)
            return this.winner; 
        throw new Exception("No winner decided");
    }

    private void evaluateGameStatus(Board board) {
        if(board.getRemainingShip() != 0)
            return;
        this.status = GameStatus.ENDED;
        this.winner = players.get(currAttackerIndex);
    }

    private void validateMove(Move move) throws Exception {
        Board board = move.getAttackedBoard();
        
        // check cell exist. the getCell method throws exception for out of bound as well as illegal cell notation so don't need to vaidate the cell notation seperately.
        Cell attackedCell = board.getCell(move.getMove());
        
        // check that the cell is not attacked
        if(attackedCell.getCellState() == CellStatus.ATTACKED)
            throw new Exception("Cannot attack the same cell twice");

    }

    public static class Builder {
        private List<Player> players;
        private Map<Player, Board> map;

        public Builder setPlayer(Player player, Board board) {
            if(players.size() >= 2)
                System.out.println("Reached max number of players");
            else {
                players.add(player);
                map.put(player, board);
            }
                
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
