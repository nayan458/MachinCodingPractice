package org.example.ChessGame.model.player;

import org.example.ChessGame.model.events.Event;
import org.example.genericUtils.Observer.Observer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player implements Observer<Event> {

    private final String name;

    @Override
    public void update(Event event) {
        System.out.println(name + ": " + event.getMessage());
    }
    
}
