package build;

class TryException extends Exception {

}

class FinallyException extends Exception {

}

public class SuppressedExceptionDemo {
    public static void main(String[] args) {
        before7();
        after7();
    }

    private static void before7() {
        try {
            try {
                throw new TryException();
            } finally {
                throw new FinallyException();
            }
        } catch (Exception e) {
            System.out.println("before7: " + e.getClass());
        }
    }

    private static void after7() {
        try {
            Throwable throwable = null;
            try {
                throw new TryException();
            } catch (Exception exception) {
                throwable = exception;
            } finally {
                FinallyException finallyException = new FinallyException();
                if (throwable != null) {
                    throwable.addSuppressed(finallyException);
                    throw throwable;
                } else {
                    throw finallyException;
                }
            }
        } catch (Throwable exception) {
            System.out.println("after7: " + exception.getClass());
            for (Throwable throwable : exception.getSuppressed()) {
                System.out.println("after7: " + throwable.getClass());
            }
        }
    }
}
