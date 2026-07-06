package org.example.TicTacToe.service;

import org.example.TicTacToe.Exceptions.GameUnplayableException;
import org.example.TicTacToe.Exceptions.UndoEmptyListException;
import org.example.TicTacToe.Strategies.WinningStrategies.WinningStrategy;
import org.example.TicTacToe.model.Game;
import org.example.TicTacToe.model.GameHistory;
import org.example.TicTacToe.model.Player;
import org.example.TicTacToe.type.GameStatus;

public class GameService {

    private final GameHistory gameHistory;

    public GameService(Game game) {
        gameHistory = new GameHistory(game);
    }
 
    public Player getNextPlayer(Game game) throws GameUnplayableException{
        if(game.getStatus() != GameStatus.INPROGRESS && game.getStatus() != GameStatus.READY_TO_PLAY)
            throw new GameUnplayableException("The game is in " + game.getStatus() + " and is not playable at this point of time.");
        return game.getPlayers().get(game.getNextPlayerIndex());
    }

    public void makeMove(Game game) throws GameUnplayableException {
        
        Player currentPlayer = getNextPlayer(game);
        
        currentPlayer.makeMove(game.getBoard());
        game.advanceTurn();
        
        checkGameStatus(currentPlayer, game);

        gameHistory.addCurrentGame(game);
    }

    public Player getWinner(Game game) throws Exception {
        if(game.getStatus() != GameStatus.END)
            throw new Exception("Please complete the game to get the winner");
        return game.getWinner();
    }

    private void checkGameStatus(Player player, Game game) {
        for(WinningStrategy winningStrategy: game.getWinningStrategies()){
            if(winningStrategy.checkWin(game.getBoard())) {
                game.endGame();
                game.setWinner(player);
            }
        }
        if(game.getBoard().isCompletelyField()) {
            game.endGame();
        }
    }

    public void displayBoard(Game game) { game.getBoard().displayBoard(); }
    public boolean isBotEnable(Game game){ return game.getEnableBot(); } 
    public GameStatus getStatus(Game game) { return game.getStatus(); }
    
    public Game undo() throws UndoEmptyListException {
        return gameHistory.undo();
    }

}
