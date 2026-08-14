package org.example.SnakeLadderGameI.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Symbol {
    private String ch;

    @Override
    public String toString(){
        return ch;
    }
}
