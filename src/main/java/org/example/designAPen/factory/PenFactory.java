package org.example.designAPen.factory;

import org.example.designAPen.abstractClasses.Pen;
import org.example.designAPen.registery.PenRegistery;
import org.example.designAPen.types.PenType;

public class PenFactory {
    private final PenRegistery penRegistery;

    public PenFactory(PenRegistery penRegistery) { this.penRegistery = penRegistery; }

    public Pen createPen(PenType type) {
        return penRegistery.getItem(type).cloneObject();
    }
}
