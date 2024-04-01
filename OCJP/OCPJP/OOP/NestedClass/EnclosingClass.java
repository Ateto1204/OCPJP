package build;

public class EnclosingClass {
    private int privateField = 101;

    // Anonymous member classes
    public Object o = new Object() {
        @Override
        public String toString() {
            return "Anonymous class as field (Object member)";
        }
    };

    // Member classes
    class MemberInner {
        public void run() {
            System.out.println("Member class: " + privateField);
        }
    }

    // Static nested classes
    static class StaticNestClass {
        public void run() {
            System.out.println("Static nested class");
        }
    }

    public void test1() {
        // Anonymous local classes
        Object o = new Object() {
            @Override
            public String toString() {
                return "Anonymous class as local variable";
            }
        };

        System.out.println(o);
        System.out.println(this.o);
    }

    public void test2() {
        // Local classes
        class LocalInner {
            public void run(String s) {
                System.out.println(s);
            }
        }

        new LocalInner().run("Local classes: " + privateField);
    }

    public static void main(String[] args) {
        EnclosingClass outer = new EnclosingClass();
        outer.test1();
        outer.test2();

        // Initial Inner classes
        MemberInner inner = outer.new MemberInner();
        inner.run();

        // Initial Static nested classes
        StaticNestClass staticNested = new EnclosingClass.StaticNestClass();
        staticNested.run();
    }
}
