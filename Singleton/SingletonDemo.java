package build;

class SingletonDemo {

    int data = 10;

    private SingletonDemo() {

    }

    private static final SingletonDemo instance = new SingletonDemo();

    public static SingletonDemo getInstance() {
        return instance;
    }
}