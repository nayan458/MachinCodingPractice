package org.example.genericUtils.interfaces;

public interface Registery<K,V> {
    void add(V value);
    void remove(V value);
    V getItem(K key);
}