public class Output {
    private static PenNibRegistery penNibRegistery = new PenNibRegistery();
    private static PenRefillRegistery penRefillRegistery = new PenRefillRegistery();
    private static PenBodyRegistery penBodyRegistery = new PenBodyRegistery();
    private static PenRegistery penRegistery = new PenRegistery();

    public static void main( String[] args ) {
        

        try {
            Bootstrap app = new Bootstrap.BootstrapBuilder()
                            .setPenNibRegistery(penNibRegistery)
                            .setPenRefillRegistery(penRefillRegistery)
                            .setPenBodyRegistery(penBodyRegistery)
                            .setPenRegistery(penRegistery)
                            .config();

            app.initialize();

        } catch (Exception e) {
            System.out.print("Failed to initialize app");
        }
            
        try {
            Pen celloMaxWriter = new PenFactory(penRegistery).createPen(PenType.BALL);
            celloMaxWriter.setPrice(10.0);
            celloMaxWriter.open();
            celloMaxWriter.write("Hello world\n");
        } catch (ClosedPenException e) {
            System.out.println(e);
        } catch (RuntimeException e) {
            System.out.println("some exception: " + e + " occured");
        }
    }
}

class PenFactory {
    private PenRegistery penRegistery;

    public PenFactory(PenRegistery penRegistery) { this.penRegistery = penRegistery; }

    public Pen createPen(PenType type) {
        return penRegistery.getItem(type).cloneObject();
    }
}

class PenRegistery implements Registery<PenType, Pen> {

    private final Map<PenType, Pen> registery = new HashMap<>();

    @Override
    public void add(Pen pen) { registery.put(pen.getPenType(), pen); }

    @Override
    public void remove(Pen pen) { registery.remove(pen.getPenType()); }

    @Override
    public Pen getItem(PenType type) { return registery.getOrDefault(type, null); }
}

class PenPrototypeRegistery implements Registery<PenType, Pen>{
    private final Map<PenType, Pen> registery = new HashMap<>();

    @Override
    public void add(Pen pen) { registery.put(pen.getPenType(), pen); }

    @Override
    public void remove(Pen pen) { registery.remove(pen.getPenType()); }

    @Override
    public Pen getItem(PenType type) { return registery.getOrDefault(type, null); }
}

class PenBodyRegistery implements Registery<MeterialType, Body> {
    private final Map<MeterialType, Body> registery = new HashMap<>();

    @Override
    public void add(Body body) { registery.put(body.getMeterial(), body); }

    @Override
    public void remove(Body body) { registery.remove(body.getMeterial()); }

    @Override
    public Body getItem(MeterialType type) { return registery.getOrDefault(type, null); }
}

class PenRefillRegistery implements Registery<PenType, Refill>{

    private final Map<PenType, Refill> registery = new HashMap<>();

    @Override
    public void add(Refill refill) { registery.put(refill.getPenType(), refill); }

    @Override
    public void remove(Refill refill) { registery.remove(refill.getPenType()); }

    @Override
    public Refill getItem(PenType type) { return registery.getOrDefault(type, null); }

}

class PenNibRegistery implements Registery<PenType, Nib> {
    private final Map<PenType, Nib> registery = new HashMap<>();

    @Override
    public void add(Nib nib) { registery.put(nib.getPenType(), nib); }

    @Override
    public void remove(Nib nib) { registery.remove(nib.getPenType()); }

    @Override
    public Nib getItem(PenType type) { return registery.getOrDefault(type, null); }
}

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
    }

    public void close() {
        state = PenState.CLOSED;
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
}




public enum MeterialType {
    METALIC, 
    WOODEN, 
    PLASTIC
}




public enum ColorType {
    RED, 
    BLUE,
    BLACK
}




public enum OpenType {
    CLICK,
    ROTATE_RIGHT,
    ROTATE_LEFT,
    PUSH
}




public enum CloseType {
    CLICK,
    HANDLE,
    ROTATE_RIGHT,
    ROTATE_LEFT,
    PUSH
}




public enum PenType {
    GEL, 
    BALL, 
    INK
}




public enum PenState {
    CLOSED,
    OPEN
}











@AllArgsConstructor
@Getter
class Body implements Clonable<Body> {
    private final String color;
    private final MeterialType meterial;
    private final Double radius;
    private final PenType penType;

    @Override
    public Body cloneObject(){
        return new Body(this.color, this.meterial, this.radius, this.penType);
    }
}









@AllArgsConstructor
class Cap implements Clonable<Cap> {

    private final MeterialType meterial;
    private final Double radius;

    @Override
    public Cap cloneObject(){
        return new Cap(this.meterial, this.radius);
    }
}











@Getter
class Refill implements Clonable<Refill> {
    private final Double radius;
    private final Nib nib;
    private final ColorType color;
    private final PenType penType;

    public Refill(Double radius, Nib nib, ColorType color, PenType penType) throws IncompatiblePartsException {
        if(!radius.equals(nib.getCompatibilityRadius())) throw new IncompatiblePartsException();
        this.radius = radius;
        this.nib = nib;
        this.color = color;
        this.penType = penType;
    }

    public Refill(Refill other) {
        radius = other.getRadius();
        nib = other.nib.cloneObject();
        color = other.getColor();
        this.penType = other.getPenType();
    }

    @Override
    public Refill cloneObject(){
        return new Refill(this);
    }
}










@AllArgsConstructor
@Getter
class Nib implements Clonable<Nib>{
    private final PenType penType;
    private final Double compatibilityRadius;

    @Override
    public Nib cloneObject(){
        return new Nib(this.penType, this.compatibilityRadius);
    }
}




public interface Refillable {
    
}











class GellPen extends Pen {
    
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












class BallPen extends Pen {

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











class InkPen extends Pen {
    
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

    public static InkPenBuilder builder() { return new InkPenBuilder(); }

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




class ClosedPenException extends Exception {
    public ClosedPenException(){
        super("Please open the pen before you start writing");
    }

    public ClosedPenException(String message) {
        super(message);
    }
}




class IncompatiblePartsException extends Exception {
    public IncompatiblePartsException() {
        super("The parts of the pen are not fit to create a complete pen.");
    }
    
    public IncompatiblePartsException(String text) {
        super(text);
    }
}










class Bootstrap implements Module {
    
    private PenNibRegistery penNibRegistery;
    private PenRefillRegistery penRefillRegistery;
    private PenBodyRegistery penBodyRegistery;
    private PenRegistery penRegistery;

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









class NibModule implements Module{
    private final PenNibRegistery penNibRegistery;

    public NibModule(PenNibRegistery penNibRegistery){ this.penNibRegistery = penNibRegistery; }

    @Override
    public void initialize() {
        try {
            penNibRegistery.add(new Nib(PenType.BALL, 0.5));
            penNibRegistery.add(new Nib(PenType.GEL, 0.8));
            penNibRegistery.add(new Nib(PenType.INK, 10.0));
        } catch (Exception e) {
            System.out.print("Failed to initialize Nib");
        }
    }
}












class RefillModule implements Module {
    
    private final PenRefillRegistery penRefillRegistery;
    private final PenNibRegistery penNibRegistery;

    public RefillModule(PenRefillRegistery penRefillRegistery, PenNibRegistery penNibRegistery) {
        this.penRefillRegistery = penRefillRegistery;
        this.penNibRegistery = penNibRegistery;
    }

    @Override
    public void initialize() {
        try {
            penRefillRegistery.add(new Refill(0.5, penNibRegistery.getItem(PenType.BALL), ColorType.BLUE, PenType.BALL));
            penRefillRegistery.add(new Refill(0.8, penNibRegistery.getItem(PenType.GEL), ColorType.BLUE, PenType.GEL));
            penRefillRegistery.add(new Refill(10.0, penNibRegistery.getItem(PenType.INK), ColorType.BLUE, PenType.INK));
        } catch (IncompatiblePartsException e) {
            System.out.println ("Nib and refill incapatibility");
        }
    }
}


















class PenModule implements Module {
    
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

class BodyModule implements Module {
    
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




public interface Registery<K,V> {
    void add(V value);
    void remove(V value);
    V getItem(K key);
}



public interface Clonable<T> {
    T cloneObject();
}




public interface Builder<T> {
    T build();
}




public interface Module {
    void initialize();   
}