package org.example.ChessGame.model.logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.example.ChessGame.model.events.Event;
import org.example.ChessGame.type.LogLevel;
import org.example.genericUtils.Observer.Observer;

public class Logger implements Observer<Event>{
    List<Log> logs;

    public Logger() {
        this.logs = new ArrayList<>();
    }

    public void update(Event event) {
        logs.add(new Log(new Date(), event.getMessage(), LogLevel.INFO));
        System.err.println("Log-" + new Date().getTime() + ": " + event.getMessage());
    };

    public void displayLogs() {
        for(Log log: logs)
            System.out.println(log);
    }
}
