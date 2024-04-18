package build;

public class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        for (int i = 0; i < 10; i++) {
            shoppingCart.addItem(new Item());
        }
        String summary = shoppingCart.getSummary();
        System.out.println(summary);
    }
}
