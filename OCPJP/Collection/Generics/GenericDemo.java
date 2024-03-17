package build;

import java.util.List;
import java.util.ArrayList;

class ListManager <T> {
    private List<T> list = new ArrayList<>();

    public void add(T t) {
        this.list.add(t);
    }

    public T get(int idx) {
        return this.list.get(idx);
    }

    void showList() {
        int n = list.size();
        for(int i = 0; i < n; i++) {
            System.out.println(list.get(i));
        }
    }
}

abstract class Employee {
    String name;
    int id;
    abstract void display();
}

class Engineer extends Employee {
    private String name;
    private int id;

    public Engineer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Engineer id #" + this.id + ": " + this.name;
    }
}

class Manager extends Employee {
    private String name;
    private int id;

    public Manager(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Manager  id #" + this.id + ": " + this.name;
    }
}

public class GenericDemo {
    private ListManager<Employee> listManager = new ListManager<>();
    public static void main(String[] args) {
        GenericDemo main = new GenericDemo();
        
        Employee engineer = new Engineer("Ateto", 133);
        main.listManager.add(engineer);

        Employee manager = new Manager("Jack", 141);
        main.listManager.add(manager);

        main.listManager.showList();
    }
}
