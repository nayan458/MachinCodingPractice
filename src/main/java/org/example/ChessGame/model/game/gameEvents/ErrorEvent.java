package org.example.ChessGame.model.game.gameEvents;

import org.example.ChessGame.model.events.Event;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorEvent implements Event {

    private final String message;

    @Override
    public String getMessage() {
        return this.message;
    }
}
