package org.example.designAPen.config;

import org.example.designAPen.prototype.BallPen;
import org.example.designAPen.prototype.GellPen;
import org.example.designAPen.prototype.InkPen;
import org.example.designAPen.prototype.BallPen.BallPenBuilder;
import org.example.designAPen.prototype.GellPen.GellPenBuilder;
import org.example.designAPen.prototype.InkPen.InkPenBuilder;
import org.example.designAPen.registery.PenBodyRegistery;
import org.example.designAPen.registery.PenRefillRegistery;
import org.example.designAPen.registery.PenRegistery;
import org.example.designAPen.types.MeterialType;
import org.example.designAPen.types.PenState;
import org.example.designAPen.types.PenType;
import org.example.genericUtils.interfaces.Module;

public class PenModule implements Module {
    
    private final PenRefillRegistery penRefillRegistery;
    private final PenBodyRegistery penBodyRegistery;
    private final PenRegistery penRegistery;

    private static final BallPenBuilder ballPenBuilder = new BallPen.BallPenBuilder();
    private final GellPenBuilder gellPenBuilder = new GellPen.GellPenBuilder();
    private final InkPenBuilder inkPenBuilder = new InkPen.InkPenBuilder();

    public PenModule(PenRefillRegistery penRefillRegistery, PenBodyRegistery penBodyRegistery, PenRegistery penRegistery) {
        this.penRefillRegistery = penRefillRegistery;
        this.penBodyRegistery = penBodyRegistery;
        this.penRegistery = penRegistery;
    }
    
    @Override
    public void initialize() {
        try {
            penRegistery.add(ballPenBuilder
                .setBody(penBodyRegistery.getItem(MeterialType.PLASTIC))
                .setBrand("Cello Max Writter")
                .setPrice(10.0)
                .setRefill(penRefillRegistery.getItem(PenType.BALL))
                .setState(PenState.CLOSED)
                .build()
            );
    
            penRegistery.add(gellPenBuilder
                .setBody(penBodyRegistery.getItem(MeterialType.PLASTIC))
                .setBrand("Cello Gel Writter")
                .setPrice(10.0)
                .setRefill(penRefillRegistery.getItem(PenType.GEL))
                .setState(PenState.CLOSED)
                .build()
            );
            penRegistery.add(inkPenBuilder
                .setBody(penBodyRegistery.getItem(MeterialType.WOODEN))
                .setBrand("Fountain Pen")
                .setPrice(30.0)
                .setRefill(penRefillRegistery.getItem(PenType.INK))
                .setState(PenState.CLOSED)
                .build()
            );
        } catch (Exception e) {
            System.out.print("Failed to initialize Pen Module");
        }
    }
}
