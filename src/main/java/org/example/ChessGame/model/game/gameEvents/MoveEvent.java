package org.example.ChessGame.model.game.gameEvents;

import org.example.ChessGame.model.events.Event;
import org.example.ChessGame.model.game.move.Move;

public class MoveEvent implements Event {
    
    private String message;

    public MoveEvent(Move gameContext) {
        this.message = gameContext.toString();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
