package org.example.SnakeLadderGameI.model;

import org.example.SnakeLadderGameI.util.RandomUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Dice {
    private int side;
    
    public int roll() {
        return RandomUtil.randomInt(1, side);
    }
}