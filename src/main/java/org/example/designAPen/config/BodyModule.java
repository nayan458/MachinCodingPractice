package org.example.designAPen.config;

import org.example.designAPen.components.Body;
import org.example.designAPen.registery.PenBodyRegistery;
import org.example.designAPen.types.MeterialType;
import org.example.designAPen.types.PenType;
import org.example.genericUtils.interfaces.Module;

public class BodyModule implements Module {
    
    private final PenBodyRegistery penBodyRegistery;

    public BodyModule(PenBodyRegistery penBodyRegistery){ this.penBodyRegistery = penBodyRegistery;}

    @Override
    public void initialize() {

        try {
            penBodyRegistery.add(new Body("Black and Blue gradiant", MeterialType.METALIC, 12.0, PenType.BALL));
            penBodyRegistery.add(new Body("Black and Blue gradiant", MeterialType.PLASTIC, 12.0, PenType.GEL));
            penBodyRegistery.add(new Body("Black and Blue gradiant", MeterialType.WOODEN, 12.0, PenType.INK));
        } catch (Exception e) {
            System.out.print("Failed to initialize Nib");
        }
    }
}
