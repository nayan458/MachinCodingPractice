package org.example.genericUtils.interfaces;

// These are the immutable registeries

public interface Resolver<K, V> {

    V resolve(K key);
    
}
