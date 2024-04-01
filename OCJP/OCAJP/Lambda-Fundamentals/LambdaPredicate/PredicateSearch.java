package build;

import java.util.List;
import java.util.ArrayList;

interface Predicate<T> {
    public boolean test(T t);
}

@FunctionalInterface
interface IChcker {
    public boolean test(Animal animal);
}

class Animal {
    private String name;
    private boolean canJump;
    private boolean canSwim;

    public Animal(String name, boolean canJump, boolean canSwim) {
        this.name = name;
        this.canJump = canJump;
        this.canSwim = canSwim;
    }

    public boolean canJump() {
        return this.canJump;
    }

    public boolean canSwim() {
        return this.canSwim;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class PredicateSearch {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("monkey", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("human", true, true));

        check(animals, animal -> animal.canJump());
    }

    private static void check(List<Animal> animals, Predicate<Animal> checker) {
        for(Animal animal : animals) {
            if(checker.test(animal)) {
                System.out.println(animal + " can jump");
            } else {
                System.out.println(animal + "can not jump");
            }
        }
    }
}
