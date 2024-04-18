package build;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        try {
            Iterator<Integer> iter = map.keySet().iterator();
            while (iter.hasNext()) {
                Integer key = iter.next();
                if (key >= 2) {
                    map.remove(key);
                }
            }
        } catch (ConcurrentModificationException exception) {
            exception.printStackTrace();
        }

        try {
            for (Integer key : map.keySet()) {
                if (key >= 0) {
                    map.remove(key);
                }
            }
        } catch (ConcurrentModificationException exception) {
            exception.printStackTrace();
        }
    }
}
