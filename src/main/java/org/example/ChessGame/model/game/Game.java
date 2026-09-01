package org.example.ChessGame.model.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.example.ChessGame.factory.MoveFactory;
import org.example.ChessGame.model.board.Board;
import org.example.ChessGame.model.events.EventBus;
import org.example.ChessGame.model.game.gameEvaluator.GameStatusEvaluator;
import org.example.ChessGame.model.game.gameEvents.ErrorEvent;
import org.example.ChessGame.model.game.gameEvents.GameEvent;
import org.example.ChessGame.model.game.gameEvents.MoveEvent;
import org.example.ChessGame.model.game.move.Move;
import org.example.ChessGame.model.game.rule.RuleValidator;
import org.example.ChessGame.model.player.Player;
import org.example.ChessGame.type.Color;
import org.example.ChessGame.type.GameStatus;
import org.example.ChessGame.type.TacticType;
import org.example.ChessGame.utils.MoveTypeEvaluator;
import org.example.ChessGame.utils.NotationUtils;

public class Game {
    private Board board;
    private final List<Player> players;
    private final RuleValidator ruleValidator;
    private final EventBus eventBus;
    private GameResult gameResult;
    private GameStatus status;
    private Integer currentPlayerIndex;
    private Scanner sc;
    private List<Board> history;
    private List<Move> moveHistory;
    private Color currentColor;

    // turn manager - (White moes first)
    // history

    private Game(GameBuilder gameBuilder) {
        this.status = GameStatus.INITIALIZING;
        this.board = gameBuilder.board;
        this.players = gameBuilder.players;
        this.ruleValidator = gameBuilder.ruleValidator;
        this.eventBus = gameBuilder.eventBus;
        this.currentPlayerIndex = 0;
        this.sc = new Scanner(System.in);
        Collections.shuffle(players);
        players.get(0).setColor(Color.WHITE);
        players.get(1).setColor(Color.BLACK);
        this.history = new ArrayList<>();
        this.history.add(board.cloneObject());
        this.moveHistory = new ArrayList<>();
        this.moveHistory.add(null);
        currentColor = Color.WHITE;
        this.status = GameStatus.READY_TO_PLAY;
    }

    public void displayBoard() {
        System.out.println(board);
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public void start() {
        Color currentColor = players.get(currentPlayerIndex).getColor();
        eventBus.publish(new GameEvent(currentColor +" TO MOVE: " + players.get(currentPlayerIndex).getName() + "'s turn") );
    }

    public boolean canUndo() {
        return history.size() > 1;
    }

    public void undo() {
        history.remove(history.size()-1);
        moveHistory.remove(moveHistory.size()-1);
        this.board = history.get(history.size() - 1);
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
        this.currentColor = players.get(currentPlayerIndex).getColor();
        eventBus.publish(new GameEvent("Move undone. " + currentColor + " TO MOVE: " + players.get(currentPlayerIndex).getName() + "'s turn"));
        displayBoard();
    }

    public String promptAction() {
        System.out.println("\nChoose an option: 1) Move  2) Resign  3) Undo last move");
        System.out.print("Enter choice: ");
        return sc.nextLine().trim();
    }

    public TacticType evaluateBoardStatus() {
        Color colorToMove = opposite(currentColor);
        TacticType tactic = GameStatusEvaluator.evaluate(board, colorToMove);

        switch (tactic) {
            case CHECKMATE -> endGame(tactic, players.get(currentPlayerIndex));
            case STALEMATE, DRAW -> endGame(tactic, null);
            case CHECK -> announceCheck(colorToMove);
            default -> { /* game continues */ }
        }

        return tactic;
    }

    private void announceCheck(Color colorInCheck) {
        Player playerInCheck = getPlayerByColor(colorInCheck);
        eventBus.publish(new GameEvent(colorInCheck + " king is in CHECK! " + playerInCheck.getName() + " must respond."));
    }

    private Player getPlayerByColor(Color color) {
        return players.get(0).getColor() == color ? players.get(0) : players.get(1);
    }

    private void endGame(TacticType tactic, Player winner) {
        this.gameResult = GameResult.of(tactic, winner);
        this.status = GameStatus.ENDED;
        eventBus.publish(new GameEvent(gameResult.toString()));
    }

    private Color opposite(Color color) {
        return color == Color.WHITE ? Color.BLACK : Color.WHITE;
    }

    public void displayStatus() {
        System.out.println(this.status.toString());
    }

    public GameResult getResult() {
        return this.gameResult;
    }

    public void resign() {
        int winnerIndex = (currentPlayerIndex + 1) % 2;
        endGame(TacticType.REGINED, players.get(winnerIndex));
    }



    public void makeMove() throws Exception {  // make a move
        
        eventBus.publish(new GameEvent(currentColor + " TO MOVE: " + players.get(currentPlayerIndex).getName() + "'s turn"));

        System.out.println("Please select the position of the piece to move:");
        String from = sc.nextLine();
        System.out.println("Please select the position where you want to place the piece:");
        String to = sc.nextLine();

        GameContext ctx = new GameContext(
            players.get(currentPlayerIndex), 
            board.getCell(NotationUtils.getIndex(from)).getPiece(), 
            board.getCell(NotationUtils.getIndex(from)), 
            board.getCell(NotationUtils.getIndex(to)), 
            to,
            moveHistory.getLast()
        );

        ruleValidator.validate(ctx, board);

        Move move = MoveFactory.getMove(MoveTypeEvaluator.evaluateMoveType(ctx),ctx);

        move.apply(board);

        eventBus.publish(new MoveEvent(move));

        history.add(board.cloneObject());
        moveHistory.add(move);
    }

    public void publishError(String message) {
        eventBus.publish(new ErrorEvent(message));
    }

    public void advanceTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
        this.currentColor = players.get(currentPlayerIndex).getColor();
        eventBus.publish(new GameEvent(currentColor + " TO MOVE: " + players.get(currentPlayerIndex).getName() + "'s turn") );
    }

    public GameStatus getStatus(){ return this.status; }

    public void viewReplay() {
        System.out.println("============= GAME REPLAY ============");
        for(Board board: history){
            System.out.println(board);
            sc.nextLine();
        }
    }

    public static class GameBuilder {
        private Board board;
        private List<Player> players;
        private RuleValidator ruleValidator;
        private EventBus eventBus;

        public GameBuilder setBoard(Board board){ this.board = board; return this;}
        public GameBuilder setPlayers(List<Player> players) throws Exception { if(players.size() != 2) throw new Exception("Exactly 2 players can play the game"); this.players = players; return this;}
        public GameBuilder setRuleValidator(RuleValidator ruleValidator){ this.ruleValidator = ruleValidator; return this; }
        public GameBuilder setEventBus(EventBus eventBus) { this.eventBus = eventBus; return this; }

        public Game build() throws IllegalArgumentException {
            if(
                board == null ||
                players == null ||
                ruleValidator == null ||
                eventBus == null
            )
            throw new IllegalArgumentException();
            return new Game(this);
        }
    }
}
