package build;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Order implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private List<Shirt> shirts = new ArrayList<>();
    static int staticField = 100;
    transient int transientField = 100;

    public Order(Shirt... shirts) {
        for(Shirt shirt : shirts) {
            this.shirts.add(shirt);
        }
        staticField = 99;
        transientField = 99;
        System.out.println("============ Constructor is launched =============");
    }

    private void writeObject(ObjectOutputStream output) throws IOException, ClassNotFoundException {
        output.defaultWriteObject();
        // keep the serialization date
        Date now = new Date();
        output.writeObject(now);
        System.out.println("\nSerialized at: " + now + "\n");
    }

    private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
        input.defaultReadObject();
        System.out.println("\nRestore from date: " + (Date) input.readObject());
        System.out.println("Restored at: " + new Date() + "\n");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Order Summary ===\n");
        for(Shirt shirt : shirts) {
            stringBuilder.append(shirt);
        }
        stringBuilder.append("staticField = " + staticField);
        stringBuilder.append("\ntransientField = " + transientField);
        stringBuilder.append("\n--------------------");
        return stringBuilder.toString();
    }
}
