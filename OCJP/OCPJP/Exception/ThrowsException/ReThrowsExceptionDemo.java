package build;

class Exception1 extends Exception {

}

class Exception2 extends Exception {

}

public class ReThrowsExceptionDemo {
    private static void rethrowsException() throws Exception1, Exception2 {
        try {
            if (Math.random() > 0.5) {
                throw new Exception1();
            } else {
                throw new Exception2();
            }
        } catch (Exception exception) {
            throw exception;
        }
    }
    public static void main(String[] args) {
        try {
            rethrowsException();
        } catch (Exception exception) {
            System.out.println(exception.getClass());
        }
    }
}