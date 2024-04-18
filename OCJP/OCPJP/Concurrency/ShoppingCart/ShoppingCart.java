package build;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Item {
    String desc() {
        return "...";
    }
}

public class ShoppingCart {
    private List<Item> cart = new ArrayList<>();
    public void addItem(Item item) {
        cart.add(item);
    }
    public void removeItem(int index) {
        cart.remove(index);
    }
    public String getSummary() {
        StringBuilder note = new StringBuilder();
        synchronized (this) {
            Iterator<Item> iter = cart.iterator();
            while (iter.hasNext()) {
                Item item = iter.next();
                note.append("Item:" + item.desc() + "\n");
            }
        }
        return note.toString();
    }
}
