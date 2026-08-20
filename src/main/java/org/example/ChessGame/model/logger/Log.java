package org.example.ChessGame.model.logger;

import java.util.Date;

import org.example.ChessGame.type.LogLevel;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Log {
    private final Date date;
    private final String message;
    private final LogLevel logLevel;

    @Override
    public String toString() {
        return logLevel + "-" + date.getTime() + ": " + message;
    }
}
