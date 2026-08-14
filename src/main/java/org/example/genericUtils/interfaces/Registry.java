package org.example.genericUtils.interfaces;

public interface Registry<K,V> {
    void add(V value);
    void remove(V value);
    V getItem(K key);
}