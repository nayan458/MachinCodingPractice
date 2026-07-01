package org.example.designAPen.config;

import org.example.designAPen.components.Nib;
import org.example.designAPen.registery.PenNibRegistery;
import org.example.designAPen.types.PenType;
import org.example.genericUtils.interfaces.Module;

public class NibModule implements Module{
    private final PenNibRegistery penNibRegistery;

    public NibModule(PenNibRegistery penNibRegistery){ this.penNibRegistery = penNibRegistery; }

    @Override
    public void initialize() {
        try {
            penNibRegistery.add(new Nib(PenType.BALL, 0.5));
            penNibRegistery.add(new Nib(PenType.GEL, 0.8));
            penNibRegistery.add(new Nib(PenType.INK, 10.0));
        } catch (Exception e) {
            System.out.print("Failed to initialize Nib");
        }
    }
}
