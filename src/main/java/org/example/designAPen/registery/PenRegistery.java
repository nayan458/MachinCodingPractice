package org.example.designAPen.registery;

import java.util.HashMap;
import java.util.Map;

import org.example.designAPen.abstractClasses.Pen;
import org.example.designAPen.types.PenType;
import org.example.genericUtils.interfaces.Registry;


public class PenRegistery implements Registry<PenType, Pen> {

    private final Map<PenType, Pen> registery = new HashMap<>();

    @Override
    public void add(Pen pen) { registery.put(pen.getPenType(), pen); }

    @Override
    public void remove(Pen pen) { registery.remove(pen.getPenType()); }

    @Override
    public Pen getItem(PenType type) { return registery.getOrDefault(type, null); }
}
