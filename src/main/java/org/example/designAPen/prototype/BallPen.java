package org.example.designAPen.prototype;

import org.example.designAPen.abstractClasses.Pen;
import org.example.designAPen.components.Body;
import org.example.designAPen.components.Refill;
import org.example.designAPen.types.PenState;
import org.example.designAPen.types.PenType;
import org.example.genericUtils.interfaces.Builder;


public class BallPen extends Pen {

    private Refill refill;

    // For creating clones
    public BallPen(BallPen other) {
        super(other.getBody(), other.getState(), other.getBrand(), other.getPrice());
        this.refill = other.refill.cloneObject();
    }
    
    // Only builder is allowed to create a instance of this type
    private BallPen(Body body, PenState state, String brand, Refill refill, Double price){ 
        super(body, state, brand, price);
        this.refill = refill;
    }

    @Override
    public PenType getPenType() { return PenType.BALL; }
    
    @Override
    public BallPen cloneObject(){ return new BallPen(this); }

    public static BallPenBuilder builder() { return new BallPenBuilder(); };

    public static class BallPenBuilder implements Builder<BallPen>{
        private Body body;
        private PenState state;
        private String brand;
        private Refill refill;
        private Double price;

        public BallPenBuilder setBody(Body body) { this.body = body; return this; }
        public BallPenBuilder setState(PenState state) { this.state = state; return this; }
        public BallPenBuilder setBrand(String brand) { this.brand = brand; return this; }
        public BallPenBuilder setRefill(Refill refill) { this.refill = refill; return this; }
        public BallPenBuilder setPrice(Double price) { this.price = price; return this; }
        

        @Override 
        public BallPen build() { return new BallPen(body,state,brand,refill,price);}
    }

}
