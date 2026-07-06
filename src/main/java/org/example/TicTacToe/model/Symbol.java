package org.example.TicTacToe.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Symbol {
    private final String ch;

    @Override
    public String toString() {
        return ch;
    }
}