package org.example.SnakeLadderGameI.registery.BoardRegistery;

import java.util.HashMap;

import org.example.SnakeLadderGameI.abstractModel.Board;
import org.example.SnakeLadderGameI.type.BoardType;
import org.example.genericUtils.interfaces.Registry;

public class BoardRegistry implements Registry<BoardType, Board> {

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

    @Override
    public void add(BoardType key, Board value) {
        REGISTRY.put(key, value);
    }

    @Override
    public void remove(BoardType key) {
        REGISTRY.remove(key);
    }

    @Override
    public Board getItem(BoardType key) {
        if(REGISTRY.containsKey(key))
            return REGISTRY.get(key);
        return REGISTRY.get(key);
    }
}
