package build;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class SerializeOrder {
    public static void main(String[] args) {
        String output = System.getProperty("user.dir") + "\\Order.ser";
        serialization(output);
        System.out.println("\n------------------------------------------\n");
        deSerialization(output);
    }

    private static void serialization(String output) {
        // Create a shirts Order
        Shirt shirt1 = new Shirt("Brand1", 100, 100);
        Shirt shirt2 = new Shirt("Brand2", 100, 200);
        Shirt shirt3 = new Shirt("Brand3", 100, 300);
        Order order = new Order(shirt1, shirt2, shirt3);

        Order.staticField = 22;

        // Write out the Order
        try (FileOutputStream fileOutput = new FileOutputStream(output); 
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
            objectOutput.writeObject(order);
        } catch (IOException exception ) {
            exception.printStackTrace();
        }
        System.out.println("=== Before Serialized, " + order);
    }

    private static void deSerialization(String output) {
        // Read the Order back in 
        try (FileInputStream fileInput = new FileInputStream(output); 
            ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
            Order restoredOrder = (Order) objectInput.readObject();
            System.out.println("=== After Serialized, " + restoredOrder);
        } catch (ClassNotFoundException | IOException exception) {
            exception.printStackTrace();
        }
    }
}
