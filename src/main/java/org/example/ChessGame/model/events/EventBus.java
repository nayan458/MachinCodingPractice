package org.example.ChessGame.model.events;

import org.example.genericUtils.Observer.Observer;

public interface EventBus {

    <T extends Event> void subscribe(
            Class<T> eventType,
            Observer<? super T> observer);

    <T extends Event> void unsubscribe(
            Class<T> eventType,
            Observer<? super T> observer);

    <T extends Event> void publish(T event);
}