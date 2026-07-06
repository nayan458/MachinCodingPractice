package org.example.designAPen.config;

import org.example.designAPen.registery.PenBodyRegistery;
import org.example.designAPen.registery.PenNibRegistery;
import org.example.designAPen.registery.PenRefillRegistery;
import org.example.designAPen.registery.PenRegistery;
import org.example.genericUtils.interfaces.Module;

public class Bootstrap implements Module {
    
    private final PenNibRegistery penNibRegistery;
    private final PenRefillRegistery penRefillRegistery;
    private final PenBodyRegistery penBodyRegistery;
    private final PenRegistery penRegistery;

    private Bootstrap(PenNibRegistery penNibRegistery,PenRefillRegistery penRefillRegistery,PenBodyRegistery penBodyRegistery,PenRegistery penRegistery) {
        this.penNibRegistery = penNibRegistery;
        this.penRefillRegistery = penRefillRegistery;
        this.penBodyRegistery = penBodyRegistery;
        this.penRegistery = penRegistery;
    }

    @Override
    public void initialize() {
        try {
            new NibModule(penNibRegistery).initialize();
            new RefillModule(penRefillRegistery, penNibRegistery).initialize();
            new BodyModule(penBodyRegistery).initialize();
            new PenModule(penRefillRegistery, penBodyRegistery, penRegistery).initialize();
        } catch (Exception e) {
            System.out.print("Failed to initialize Nib");
        }
    }

    public static BootstrapBuilder builder(){ return new BootstrapBuilder(); }

    public static class BootstrapBuilder {
        private PenNibRegistery penNibRegistery;
        private PenRefillRegistery penRefillRegistery;
        private PenBodyRegistery penBodyRegistery;
        private PenRegistery penRegistery;

        public BootstrapBuilder setPenNibRegistery(PenNibRegistery penNibRegistery) { this.penNibRegistery = penNibRegistery; return this;}
        public BootstrapBuilder setPenRefillRegistery(PenRefillRegistery penRefillRegistery) { this.penRefillRegistery = penRefillRegistery; return this;}
        public BootstrapBuilder setPenBodyRegistery(PenBodyRegistery penBodyRegistery) { this.penBodyRegistery = penBodyRegistery; return this;}
        public BootstrapBuilder setPenRegistery(PenRegistery penRegistery) { this.penRegistery = penRegistery; return this;}

        public Bootstrap config() {
            if(penNibRegistery == null ||
                penRefillRegistery == null ||
                penBodyRegistery == null ||
                penRegistery == null
            ) throw new IllegalArgumentException("All arguments are required to provide");
            return new Bootstrap(penNibRegistery, penRefillRegistery, penBodyRegistery, penRegistery);
        }
    }
    
}
