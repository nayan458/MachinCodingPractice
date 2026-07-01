package org.example.designAPen.registery;

import java.util.HashMap;
import java.util.Map;

import org.example.designAPen.components.Body;
import org.example.designAPen.types.MeterialType;
import org.example.genericUtils.interfaces.Registery;

public class PenBodyRegistery implements Registery<MeterialType, Body> {
    private final Map<MeterialType, Body> registery = new HashMap<>();

    @Override
    public void add(Body body) { registery.put(body.getMeterial(), body); }

    @Override
    public void remove(Body body) { registery.remove(body.getMeterial()); }

    @Override
    public Body getItem(MeterialType type) { return registery.getOrDefault(type, null); }
}
