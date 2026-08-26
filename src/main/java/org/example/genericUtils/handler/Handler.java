package org.example.genericUtils.handler;

public interface Handler<T> {
    public void setNext(T next);
    public void next() throws Exception;
}
