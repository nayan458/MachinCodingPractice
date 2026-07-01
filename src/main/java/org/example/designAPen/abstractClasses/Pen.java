package org.example.designAPen.abstractClasses;

import org.example.designAPen.components.Body;
import org.example.designAPen.exceptions.ClosedPenException;
import org.example.designAPen.types.PenState;
import org.example.designAPen.types.PenType;
import org.example.genericUtils.interfaces.Clonable;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public abstract class Pen implements Clonable<Pen>{
    
    private final Body body;
    private PenState state;
    private final String brand;
    private Double price;
    
    // private CloseType closeType;
    // private OpenType openType;

    public abstract PenType getPenType();

    public void open() {
        state = PenState.OPEN;
        System.out.println("Pen is opened");
    }

    public void close() {
        state = PenState.CLOSED;
        System.out.println("Pen is closed");
    }

    // private void Action(Action action) {

    // }

    public void write(String text) throws ClosedPenException {
        if(state != PenState.OPEN)
            throw new ClosedPenException();
        System.out.print(text);
    }

    public void setPrice(Double newPrice) throws IllegalArgumentException {
        if(newPrice == null || newPrice <= 0)
            throw new IllegalArgumentException();
        this.price = newPrice;
    }

    @Override
    public String toString() {
        return "Pen [brand=" + brand + ", price=" + price + ", state=" + state + "]";
    }

}
