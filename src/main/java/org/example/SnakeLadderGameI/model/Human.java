package org.example.SnakeLadderGameI.model;

import org.example.SnakeLadderGameI.abstractModel.Player;
import org.example.SnakeLadderGameI.type.PlayerType;

public class Human extends Player {

    private Human(String name, PlayerType type, Symbol symbol) {
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

    public static class HumanBuilder{
        private String name;
        private PlayerType type;
        private Symbol symbol;

        public HumanBuilder setname (String name){
            this.name = name; return this;
        }
        public HumanBuilder settype (PlayerType type){
            this.type = type; return this;
        }
        public HumanBuilder setsymbol (Symbol symbol){
            this.symbol = symbol; return this;
        }

        public Human build(){
            if(
                name == null ||
                type == null ||
                symbol == null
            ) throw new IllegalArgumentException();
            return new Human(name, type, symbol);
        }
    }
}
