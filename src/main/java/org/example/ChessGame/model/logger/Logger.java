package org.example.ChessGame.model.logger;

import java.util.Date;

import org.example.ChessGame.model.events.Event;
import org.example.genericUtils.Observer.Observer;

public class Logger implements Observer<Event>{
    public void update(Event event) {
        System.err.println("Log-" + new Date().getTime() + ": " + event.getMessage());
    };
}
