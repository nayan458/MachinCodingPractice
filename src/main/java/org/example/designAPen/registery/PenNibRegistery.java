package org.example.designAPen.registery;

import java.util.HashMap;
import java.util.Map;

import org.example.designAPen.components.Nib;
import org.example.designAPen.types.PenType;
import org.example.genericUtils.interfaces.Registry;

public class PenNibRegistery implements Registry<PenType, Nib> {
    private final Map<PenType, Nib> registery = new HashMap<>();

    @Override
    public void add(Nib nib) { registery.put(nib.getPenType(), nib); }

    @Override
    public void remove(Nib nib) { registery.remove(nib.getPenType()); }

    @Override
    public Nib getItem(PenType type) { return registery.getOrDefault(type, null); }
}
