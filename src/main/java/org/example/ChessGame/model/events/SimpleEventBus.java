package org.example.ChessGame.model.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.genericUtils.Observer.Observer;

public class SimpleEventBus implements EventBus {

    private final Map<Class<? extends Event>, List<Observer<? super Event>>> subscribers =
            new HashMap<>();

    @Override
    public <T extends Event> void subscribe(Class<T> eventType, Observer<? super T> observer) {
        subscribers
                .computeIfAbsent(eventType, key -> new ArrayList<>())
                .add((Observer<? super Event>) observer);
    }

    @Override
    public <T extends Event> void unsubscribe(Class<T> eventType, Observer<? super T> observer) {
        List<Observer<? super Event>> observers = subscribers.get(eventType);

        if (observers == null) {
            return;
        }

        observers.remove(observer);

        if (observers.isEmpty()) {
            subscribers.remove(eventType);
        }
    }

    @Override
    public <T extends Event> void publish(T event) {
        List<Observer<? super Event>> observers =
                subscribers.get(event.getClass());

        if (observers == null) {
            return;
        }

        for (Observer<? super Event> observer : observers) {
            observer.update(event);
        }
    }
}