package org.example.designAPen.config;

import org.example.designAPen.components.Refill;
import org.example.designAPen.exceptions.IncompatiblePartsException;
import org.example.designAPen.registery.PenNibRegistery;
import org.example.designAPen.registery.PenRefillRegistery;
import org.example.designAPen.types.ColorType;
import org.example.designAPen.types.PenType;
import org.example.genericUtils.interfaces.Module;

public class RefillModule implements Module {
    
    private final PenRefillRegistery penRefillRegistery;
    private final PenNibRegistery penNibRegistery;

    public RefillModule(PenRefillRegistery penRefillRegistery, PenNibRegistery penNibRegistery) {
        this.penRefillRegistery = penRefillRegistery;
        this.penNibRegistery = penNibRegistery;
    }

    @Override
    public void initialize() {
        try {
            penRefillRegistery.add(new Refill(0.5, penNibRegistery.getItem(PenType.BALL), ColorType.BLUE, PenType.BALL));
            penRefillRegistery.add(new Refill(0.8, penNibRegistery.getItem(PenType.GEL), ColorType.BLUE, PenType.GEL));
            penRefillRegistery.add(new Refill(10.0, penNibRegistery.getItem(PenType.INK), ColorType.BLUE, PenType.INK));
        } catch (IncompatiblePartsException e) {
            System.out.println ("Nib and refill incapatibility");
        }
    }
}
