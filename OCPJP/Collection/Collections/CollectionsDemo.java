package build;

import java.util.Map;
import java.util.SortedSet;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Queue;
import java.util.ArrayDeque;

public class CollectionsDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.putIfAbsent(10, 0);
        map.replace(11, 0);
        int getValue = map.getOrDefault(12, -1);
        System.out.println(getValue);

        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("demo2");
        sortedSet.add("demo1");
        sortedSet.add("demo3");
        for(Object o : sortedSet) {
            System.out.println(o);
        }

        Queue<Double> queue = new ArrayDeque<>();
    }
}
