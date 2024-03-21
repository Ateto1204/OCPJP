/*
 * 
 * Author: Ateto
 * 
 * Description: Demo to Factory design pattern
 * 
 */

package build;

interface Product {
    void use();
}

class ConcreteProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using Product A");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using Product B");
    }
}

class Factory {
    public static Product createProduct(String type) {
        if(type.equals("A")) {
            return new ConcreteProductA();
        } else if(type.equals("B")) {
            return new ConcreteProductB();
        } else {
            throw new IllegalArgumentException("Unknown product type");
        }
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        try {
            Product productA = Factory.createProduct("A");
            productA.use();

            Product productB = Factory.createProduct("B");
            productB.use();

            Product productC = Factory.createProduct("C");
            productC.use();

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}