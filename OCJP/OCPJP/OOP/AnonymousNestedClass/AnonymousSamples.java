package build;

class MySuper {
    void doIt() {}
}

interface MyInterface {
    void doIt();
}

class MySub extends MySuper {
    void doIt() {
        System.out.println("This is MySub");
    }
}

class MyImpl implements MyInterface {
    public void doIt() {
        System.out.println("This is MyImpl");
    }
}

public class AnonymousSamples {
    MySuper c1 = new MySub();
    MySuper c2 = new MySuper() {
        void doIt() {
            System.out.println("This is Anonymous Sub class");
        }
    };

    MyInterface i1 = new MyImpl();
    MyInterface i2 = new MyInterface() {
        public void doIt() {
            System.out.println("This is Anonymous Impl class");
        }
    };
    
    public static void main(String[] args) {
        AnonymousSamples c = new AnonymousSamples();
        c.c1.doIt();
        c.c2.doIt();
        c.i1.doIt();
        c.i2.doIt();
    }
}
