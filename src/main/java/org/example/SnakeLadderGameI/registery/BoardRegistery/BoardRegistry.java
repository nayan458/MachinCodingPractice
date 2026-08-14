package org.example.SnakeLadderGameI.registery.BoardRegistery;

import java.util.HashMap;

import org.example.SnakeLadderGameI.abstractModel.Board;
import org.example.SnakeLadderGameI.type.BoardType;

public class BoardRegistry {

    private final HashMap<BoardType, Board> REGISTRY = new HashMap<>();
    private static volatile BoardRegistry INSTANCE;

    private BoardRegistry() {
        REGISTRY.put(BoardType.EASY, new EasyBoard());
        REGISTRY.put(BoardType.STANDARD, new StandardBoard());
        REGISTRY.put(BoardType.HARD, new HardBoard());
    }

    public static BoardRegistry getInstance() {
        if(BoardRegistry.INSTANCE == null){
            synchronized(BoardRegistry.class) {
                if(INSTANCE == null)
                    INSTANCE = new BoardRegistry();
            }
        }
        return INSTANCE;
    }

    public void add(BoardType key, Board value) {
        REGISTRY.put(key, value);
    }

    public void remove(BoardType key) {
        REGISTRY.remove(key);
    }

    public Board getItem(BoardType key) {
        if(REGISTRY.containsKey(key))
            return REGISTRY.get(key);
        return REGISTRY.get(key);
    }
}
