package org.example.designAPen.prototype;

import org.example.designAPen.abstractClasses.Pen;
import org.example.designAPen.components.Body;
import org.example.designAPen.components.Refill;
import org.example.designAPen.types.PenState;
import org.example.designAPen.types.PenType;
import org.example.genericUtils.interfaces.Builder;

public class InkPen extends Pen {
    
    private final Refill refill;

    public InkPen(Body body, PenState state, String brand, Refill refill, Double price){
        super(body, state, brand, price);
        this.refill = refill;
    }

    @Override
    public PenType getPenType() { return PenType.INK; }

    @Override
    public InkPen cloneObject(){
        return new InkPen(this.getBody(), this.getState(), this.getBrand(), this.refill, this.getPrice());
    }

    @Override
    public String toString() {
        return "InkPen [refill=" + refill + ", brand=" + getBrand() + ", price=" + getPrice() + ", state=" + getState() + "]";
    }

    public static class InkPenBuilder implements Builder<InkPen>{
        private Body body;
        private PenState state;
        private String brand;
        private Refill refill;
        private Double price;

        public InkPenBuilder setBody(Body body) { this.body = body; return this; }
        public InkPenBuilder setState(PenState state) { this.state = state; return this; }
        public InkPenBuilder setBrand(String brand) { this.brand = brand; return this; }
        public InkPenBuilder setRefill(Refill refill) { this.refill = refill; return this; }
        public InkPenBuilder setPrice(Double price) { this.price = price; return this; }
        

        @Override 
        public InkPen build() { return new InkPen(body,state,brand,refill,price);}
    }
    
    
}
