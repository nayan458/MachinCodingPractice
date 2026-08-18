package org.example.ChessGame.model.game.gameEvents;

import org.example.ChessGame.model.events.Event;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameEvent implements Event {       
    // publish messages like:
    // p2 resigned
    // game ended with a checkmate and x wins 
    // game ended with a draw

    private String message;

    @Override
    public String getMessage() {
        return this.message;
    }
}
