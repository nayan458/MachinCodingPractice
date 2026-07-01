package org.example.designAPen;

import org.example.designAPen.abstractClasses.Pen;
import org.example.designAPen.config.Bootstrap;
import org.example.designAPen.exceptions.ClosedPenException;
import org.example.designAPen.factory.PenFactory;
import org.example.designAPen.registery.PenBodyRegistery;
import org.example.designAPen.registery.PenNibRegistery;
import org.example.designAPen.registery.PenRefillRegistery;
import org.example.designAPen.registery.PenRegistery;
import org.example.designAPen.types.PenType;

public class App 
{
    private static final PenNibRegistery penNibRegistery = new PenNibRegistery();
    private static final PenRefillRegistery penRefillRegistery = new PenRefillRegistery();
    private static final PenBodyRegistery penBodyRegistery = new PenBodyRegistery();
    private static final PenRegistery penRegistery = new PenRegistery();

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

            System.out.println(celloMaxWriter);
            celloMaxWriter.open();
            celloMaxWriter.write("Hello world\n");
        } catch (ClosedPenException e) {
            System.out.println(e);
        } catch (RuntimeException e) {
            System.out.println("some exception: " + e + " occured");
        }
    }
}
