package org.example.designAPen.components;

import org.example.designAPen.types.MeterialType;
import org.example.genericUtils.interfaces.Clonable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Cap implements Clonable<Cap> {

    private final MeterialType meterial;
    private final Double radius;

    @Override
    public Cap cloneObject(){
        return new Cap(this.meterial, this.radius);
    }
}
