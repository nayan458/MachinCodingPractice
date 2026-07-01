package org.example.designAPen.prototype;

import org.example.designAPen.abstractClasses.Pen;
import org.example.designAPen.components.Body;
import org.example.designAPen.components.Refill;
import org.example.designAPen.types.PenState;
import org.example.designAPen.types.PenType;
import org.example.genericUtils.interfaces.Builder;

public class GellPen extends Pen {
    
    private final Refill refill;

    public GellPen(Body body, PenState state, String brand, Refill refill, Double price){
        super(body, state, brand, price);
        this.refill = refill;
    }

    @Override
    public PenType getPenType() { return PenType.GEL; }

    @Override
    public GellPen cloneObject(){
        return new GellPen(this.getBody(), this.getState(), this.getBrand(), this.refill, this.getPrice());
    }

    public static GellPenBuilder builder() { return new GellPenBuilder(); }

    public static class GellPenBuilder implements Builder<GellPen>{
        private Body body;
        private PenState state;
        private String brand;
        private Refill refill;
        private Double price;

        public GellPenBuilder setBody(Body body) { this.body = body; return this; }
        public GellPenBuilder setState(PenState state) { this.state = state; return this; }
        public GellPenBuilder setBrand(String brand) { this.brand = brand; return this; }
        public GellPenBuilder setRefill(Refill refill) { this.refill = refill; return this; }
        public GellPenBuilder setPrice(Double price) { this.price = price; return this; }
        

        @Override 
        public GellPen build() { return new GellPen(body,state,brand,refill,price);}
    }
}
