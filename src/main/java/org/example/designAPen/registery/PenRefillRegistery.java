package org.example.designAPen.registery;

import java.util.HashMap;
import java.util.Map;

import org.example.designAPen.components.Refill;
import org.example.designAPen.types.PenType;
import org.example.genericUtils.interfaces.Registry;

public class PenRefillRegistery implements Registry<PenType, Refill>{

    private final Map<PenType, Refill> registery = new HashMap<>();

    @Override
    public void add(Refill refill) { registery.put(refill.getPenType(), refill); }

    @Override
    public void remove(Refill refill) { registery.remove(refill.getPenType()); }

    @Override
    public Refill getItem(PenType type) { return registery.getOrDefault(type, null); }

}
