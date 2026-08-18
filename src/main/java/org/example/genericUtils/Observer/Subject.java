package org.example.genericUtils.Observer;

public interface Subject<E> {
    void subscribe(Observer<E> subscriber);
    void unSubscribe(Observer<E> subscriber);
    void notifyObserver(E event);
}
