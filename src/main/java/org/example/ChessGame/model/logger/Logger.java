package org.example.ChessGame.model.logger;

import org.example.ChessGame.model.events.IGameEvent;
import org.example.genericUtils.Observer.Observer;

public class Logger implements Observer<IGameEvent>{
    public void update(IGameEvent event) {};
}
