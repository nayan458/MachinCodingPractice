package org.example.designAPen.components;

import org.example.designAPen.types.MeterialType;
import org.example.designAPen.types.PenType;
import org.example.genericUtils.interfaces.Clonable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Body implements Clonable<Body> {
    private final String color;
    private final MeterialType meterial;
    private final Double radius;
    private final PenType penType;

    @Override
    public Body cloneObject(){
        return new Body(this.color, this.meterial, this.radius, this.penType);
    }
}
