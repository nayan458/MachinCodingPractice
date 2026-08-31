package org.example.ChessGame.model.logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.example.ChessGame.model.events.Event;
import org.example.ChessGame.model.game.gameEvents.ErrorEvent;
import org.example.ChessGame.type.LogLevel;
import org.example.genericUtils.Observer.Observer;

public class Logger implements Observer<Event>{
    List<Log> logs;

    public Logger() {
        this.logs = new ArrayList<>();
    }

    public void update(Event event) {
        LogLevel level = event instanceof ErrorEvent ? LogLevel.ERROR : LogLevel.INFO;
        Log log = new Log(new Date(), event.getMessage(), level);
        logs.add(log);
        System.err.println(log);
    };

    public void displayLogs() {
        for(Log log: logs)
            System.out.println(log);
    }
}
