package org.example.designAPen.components;

import org.example.designAPen.types.PenType;
import org.example.genericUtils.interfaces.Clonable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Nib implements Clonable<Nib>{
    private final PenType penType;
    private final Double compatibilityRadius;

    @Override
    public Nib cloneObject(){
        return new Nib(this.penType, this.compatibilityRadius);
    }

    @Override
    public String toString() {
        return "Nib [penType=" + penType + ", compatibilityRadius=" + compatibilityRadius + "]";
    }
}
