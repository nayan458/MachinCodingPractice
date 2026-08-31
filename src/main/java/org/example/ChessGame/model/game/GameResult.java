package org.example.ChessGame.model.game;

import org.example.ChessGame.model.player.Player;
import org.example.ChessGame.type.TacticType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GameResult {
    private final TacticType tactic;
    private final Player winner;

    public static GameResult of(TacticType tactic, Player winner) {
        return new GameResult(tactic, winner);
    }

    public boolean isGameOver() {
        return switch (tactic) {
            case CHECKMATE, STALEMATE, DRAW, REGINED -> true;
            default -> false;
        };
    }

    @Override
    public String toString () {
        switch (tactic) {
            case CHECKMATE:
                return checkMateTemplateString();
            case STALEMATE:
                return staleMateTemplateString();
            case DRAW:
                return drawTemplateString();
            case REGINED:
                return resignTemplateString();
            default:
                 return "";
        }
    }

    private String checkMateTemplateString() { return "The winner is: " + winner.getName() + " won by " + tactic; }
    private String staleMateTemplateString() { return "There is no valid move and the game ended with: " + tactic; }
    private String resignTemplateString() { return "The winner is: " + winner.getName() + ", oponent " + tactic; }
    private String drawTemplateString() { return "The game is: " + tactic; }
}
