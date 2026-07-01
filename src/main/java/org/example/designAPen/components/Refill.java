package org.example.designAPen.components;

import org.example.designAPen.exceptions.IncompatiblePartsException;
import org.example.designAPen.types.ColorType;
import org.example.designAPen.types.PenType;
import org.example.genericUtils.interfaces.Clonable;

import lombok.Getter;

@Getter
public class Refill implements Clonable<Refill> {
    private final Double radius;
    private final Nib nib;
    private final ColorType color;
    private final PenType penType;

    public Refill(Double radius, Nib nib, ColorType color, PenType penType) throws IncompatiblePartsException {
        if(!radius.equals(nib.getCompatibilityRadius())) throw new IncompatiblePartsException();
        this.radius = radius;
        this.nib = nib;
        this.color = color;
        this.penType = penType;
    }

    public Refill(Refill other) {
        radius = other.getRadius();
        nib = other.nib.cloneObject();
        color = other.getColor();
        this.penType = other.getPenType();
    }

    @Override
    public Refill cloneObject(){
        return new Refill(this);
    }
}
