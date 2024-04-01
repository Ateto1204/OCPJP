package build;

import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Shirt implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String brand;
    private int quantity;
    private double cost;
    private transient double price;

    public Shirt(String brand, int quantity, double cost) {
        this.brand = brand;
        this.quantity = quantity;
        this.cost = cost;
        this.price = cost * 2;
    }

    // This method is called post-serialization
    private void readObject(ObjectInputStream input) throws IOException, 
                                                            ClassNotFoundException {
        input.defaultReadObject();
        // perform other initiliazation
        this.price = this.cost + 50;
    }

    @Override
    public String toString() {
        return "Shirt: " + this.brand + "\n"
                + "Quantity: " + this.quantity + "\n"
                + "Cost: " + this.cost + "\n"
                + "Price: " + this.price + "\n"
                + "-----------------------\n";
    }
}
