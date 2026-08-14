package org.example.genericUtils.interfaces;

// These is for the usecase where each item of a registery belongs to a unique entity.

public interface Allocator<T> {
    T allocate() throws Exception;
    void release(T item);
}