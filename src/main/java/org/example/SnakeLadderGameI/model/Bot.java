package org.example.SnakeLadderGameI.model;

import org.example.SnakeLadderGameI.abstractModel.Player;
import org.example.SnakeLadderGameI.type.PlayerType;

public class Bot extends Player {

    private Bot(String name, PlayerType type, Symbol symbol){
        super(name, symbol, type);
    }

    @Override
    public Move makeMove(Dice dice) {
        try {
            return new Move(this, dice.roll());   
        } catch (Exception e) {
            System.out.println("Error while making move: " + e.getMessage());
            return null;
        }
    }

    public static class BotBuilder {
        private String name;
        private PlayerType type; 
        private Symbol symbol; 

        public BotBuilder setName(String name){ this.name = name; return this; }
        public BotBuilder setType(PlayerType type){ this.type = type ; return this; }
        public BotBuilder setSymbol(Symbol symbol){ this.symbol = symbol ; return this; }

        public Bot build(){
            if(
                name == null ||
                type == null ||
                symbol == null
                )
                throw new IllegalArgumentException("Please set all the values before proceeding forward");
            return new Bot(name, type, symbol);
        }
    }

}
