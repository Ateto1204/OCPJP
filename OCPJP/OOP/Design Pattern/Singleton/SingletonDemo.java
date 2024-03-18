package build;

class SingletonClass {

    int data = 10;

    private SingletonClass() {

    }

    private static final SingletonClass instance = new SingletonClass();

    public static SingletonClass getInstance() {
        return instance;
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        SingletonClass ref1 = SingletonClass.getInstance();
        SingletonClass ref2 = SingletonClass.getInstance();

        ref1.data = 5;

        System.out.println(ref2.data);
    }
}