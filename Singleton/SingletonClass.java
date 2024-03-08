package build;

public class SingletonClass {
    public static void main(String[] args) {
        SingletonDemo ref1 = SingletonDemo.getInstance();
        SingletonDemo ref2 = SingletonDemo.getInstance();

        ref1.data = 5;

        System.out.println(ref2.data);
    }
}